package com.huashitu.liveradio.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;
import com.alibaba.livecloud.live.AlivcMediaFormat;
import com.alibaba.livecloud.live.AlivcMediaRecorder;
import com.alibaba.livecloud.live.AlivcMediaRecorderFactory;
import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;
import com.midian.base.base.BaseActivity;
import java.util.HashMap;
import java.util.Map;

/**
 * 自己直播
 * Created by Administrator on 2016/11/17 0017.
 */

public class Activity_LiveRadio extends BaseActivity {



    public static class RequestBuilder {
        String rtmpUrl;//推流地址
        int videoResolution;//画质
        int cameraFacing;//切换摄像头
        int bestBitrate;
        int minBitrate;
        int maxBitrate;
        int initBitrate;
        int frameRate;//帧率，必须是0~30之间

        public RequestBuilder rtmpUrl(String url) {
            this.rtmpUrl = url;
            return this;
        }

        public RequestBuilder videoResolution(int resolution) {
            this.videoResolution = resolution;
            return this;
        }

        public RequestBuilder cameraFacing(int cameraFacing) {
            this.cameraFacing = cameraFacing;
            return this;
        }

        public RequestBuilder bestBitrate(int bestBitrate) {
            this.bestBitrate = bestBitrate;
            return this;
        }

        public RequestBuilder minBitrate(int minBitrate) {
            this.minBitrate = minBitrate;
            return this;
        }

        public RequestBuilder maxBitrate(int maxBitrate) {
            this.maxBitrate = maxBitrate;
            return this;
        }

        public RequestBuilder initBitrate(int initBitrate) {
            this.initBitrate = initBitrate;
            return this;
        }

        public RequestBuilder frameRate(int frameRate) {
            this.frameRate = frameRate;
            return this;
        }

        public Intent build(Context context) {
            Intent intent = new Intent(context, Activity_LiveRadio.class);
            intent.putExtra(URL, rtmpUrl);
            intent.putExtra(VIDEO_RESOLUTION, videoResolution);
            intent.putExtra(FRONT_CAMERA_FACING, cameraFacing);
            intent.putExtra(BEST_BITRATE, bestBitrate);
            intent.putExtra(MIN_BITRATE, minBitrate);
            intent.putExtra(MAX_BITRATE, maxBitrate);
            intent.putExtra(INIT_BITRATE, initBitrate);
            intent.putExtra(FRAME_RATE, frameRate);
            return intent;
        }

    }

    public final static String URL = "url";
    public final static String VIDEO_RESOLUTION = "video_resolution";
    public final static String FRONT_CAMERA_FACING = "front_camera_face";
    public final static String BEST_BITRATE = "best-bitrate";
    public final static String MIN_BITRATE = "min-bitrate";
    public final static String MAX_BITRATE = "max-bitrate";
    public final static String INIT_BITRATE = "init-bitrate";
    public final static String FRAME_RATE = "frame-rate";


    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String[] permissionManifest = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
    };
    private final int PERMISSION_DELAY = 100;
    private boolean mHasPermission = false;

    public static void startActivity(Context context,
                                     RequestBuilder builder) {
        Intent intent = builder.build(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private SurfaceView _CameraSurface;
    private AlivcMediaRecorder mMediaRecorder;
    private Surface mPreviewSurface;
    private Map<String, Object> mConfigure = new HashMap<>();
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveradio);
        if (Build.VERSION.SDK_INT >= 23) {
            permissionCheck();
        } else {
            mHasPermission = true;
        }
        getExtraData();

        //采集
        _CameraSurface = (SurfaceView) findViewById(R.id.camera_surface);
        _CameraSurface.getHolder().addCallback(_CameraSurfaceCallback);
        _CameraSurface.setOnTouchListener(mOnTouchListener);

        //对焦，缩放
        mDetector = new GestureDetector(_CameraSurface.getContext(), mGestureDetector);
        mScaleDetector = new ScaleGestureDetector(_CameraSurface.getContext(), mScaleGestureListener);

        mMediaRecorder = AlivcMediaRecorderFactory.createMediaRecorder();
        mMediaRecorder.init(this);
        mMediaRecorder.addFlag(AlivcMediaFormat.FLAG_BEAUTY_ON);//开启美颜

        mConfigure.put(AlivcMediaFormat.KEY_CAMERA_FACING, cameraFrontFacing);
        mConfigure.put(AlivcMediaFormat.KEY_MAX_ZOOM_LEVEL, 3);
        mConfigure.put(AlivcMediaFormat.KEY_OUTPUT_RESOLUTION, resolution);
        mConfigure.put(AlivcMediaFormat.KEY_MAX_VIDEO_BITRATE, maxBitrate * 1000);
        mConfigure.put(AlivcMediaFormat.KEY_BEST_VIDEO_BITRATE, bestBitrate *1000);
        mConfigure.put(AlivcMediaFormat.KEY_MIN_VIDEO_BITRATE, minBitrate * 1000);
        mConfigure.put(AlivcMediaFormat.KEY_INITIAL_VIDEO_BITRATE, initBitrate * 1000);
        mConfigure.put(AlivcMediaFormat.KEY_EXPOSURE_COMPENSATION, -1);//曝光度
        mConfigure.put(AlivcMediaFormat.KEY_FRAME_RATE, frameRate);
    }

    private void permissionCheck() {
        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (String permission : permissionManifest) {
            if (PermissionChecker.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionCheck = PackageManager.PERMISSION_DENIED;
            }
        }
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissionManifest, PERMISSION_REQUEST_CODE);
        } else {
            mHasPermission = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPreviewSurface != null) {
            mMediaRecorder.prepare(mConfigure, mPreviewSurface);
        }
    }

    private String pushUrl;
    private int resolution;
    private int cameraFrontFacing;
    private int bestBitrate;
    private int minBitrate;
    private int maxBitrate;
    private int initBitrate;
    private int frameRate;

    private void getExtraData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pushUrl = bundle.getString(URL);
            resolution = bundle.getInt(VIDEO_RESOLUTION);
            cameraFrontFacing = bundle.getInt(FRONT_CAMERA_FACING);
            minBitrate = bundle.getInt(MIN_BITRATE);
            maxBitrate = bundle.getInt(MAX_BITRATE);
            bestBitrate = bundle.getInt(BEST_BITRATE);
            initBitrate = bundle.getInt(INIT_BITRATE);
            frameRate = bundle.getInt(FRAME_RATE);
        }
    }

    private final SurfaceHolder.Callback _CameraSurfaceCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            holder.setKeepScreenOn(true);
            mPreviewSurface = holder.getSurface();
            startPreview(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            mMediaRecorder.setPreviewSize(width, height);
            mPreviewWidth = width;
            mPreviewHeight = height;
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mPreviewSurface = null;
            mMediaRecorder.stopRecord();
            mMediaRecorder.reset();
        }
    };

    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;
    private GestureDetector.SimpleOnGestureListener mGestureDetector = new GestureDetector.SimpleOnGestureListener(){

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (mPreviewWidth > 0 && mPreviewHeight > 0) {
                float x = motionEvent.getX() / mPreviewWidth;
                float y = motionEvent.getY() / mPreviewHeight;
                LogUtils.e(motionEvent);
                mMediaRecorder.focusing(x, y);
            }
            return true;
        }
    };

    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mDetector.onTouchEvent(motionEvent);
            mScaleDetector.onTouchEvent(motionEvent);
            return true;
        }
    };


    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mMediaRecorder.setZoom(scaleGestureDetector.getScaleFactor());
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };

    private void startPreview(final SurfaceHolder holder) {
        if(!mHasPermission) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startPreview(holder);
                }
            }, PERMISSION_DELAY);
            return;
        }
        mMediaRecorder.prepare(mConfigure, mPreviewSurface);
        mMediaRecorder.setPreviewSize(_CameraSurface.getMeasuredWidth(), _CameraSurface.getMeasuredHeight());
        if ((int) mConfigure.get(AlivcMediaFormat.KEY_CAMERA_FACING) == AlivcMediaFormat.CAMERA_FACING_FRONT) {
            mMediaRecorder.addFlag(AlivcMediaFormat.FLAG_BEAUTY_ON);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                boolean hasPermission = true;
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        int toastTip = 0;
                        if (Manifest.permission.CAMERA.equals(permissions[i])) {
                            toastTip = R.string.no_camera_permission;
                        } else if (Manifest.permission.RECORD_AUDIO.equals(permissions[i])) {
                            toastTip = R.string.no_record_audio_permission;
                        }
                        if (toastTip != 0) {
                            Toast.makeText(this,getString(toastTip),Toast.LENGTH_SHORT).show();
                            hasPermission = false;
                        }
                    }
                }
                mHasPermission = hasPermission;
                break;
        }
    }

}
