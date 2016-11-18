package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.alivc.player.AliVcMediaPlayer;
import com.alivc.player.MediaPlayer;
import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.widget.ShareDialog;
import com.midian.base.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 观看别人直播
 * Created by Administrator on 2016/11/18 0018.
 */

public class Activity_WatchRadio extends BaseActivity {

    @BindView(R.id.surfaceView)
    SurfaceView mSurfaceView;
    @BindView(R.id.btn_Talk)
    ImageButton btnTalk;
    @BindView(R.id.btn_Message)
    ImageButton btnMessage;
    @BindView(R.id.btn_Gift)
    ImageButton btnGift;
    @BindView(R.id.btn_Share)
    ImageButton btnShare;
    @BindView(R.id.btn_Exit)
    ImageButton btnExit;
    @BindView(R.id.ll_Bot)
    LinearLayout llBot;

    private SurfaceHolder mSurfaceHolder;
    private AliVcMediaPlayer mPlayer;
    private String msUri = "rtmp://live.hkstv.hk.lxdns.com/live/hks";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchradio);
        ButterKnife.bind(this);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(mSurfaceHolderCB);
    }

    private SurfaceHolder.Callback mSurfaceHolderCB = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
            holder.setSizeFromLayout();
            holder.setKeepScreenOn(true);
            if (mPlayer != null) {
                mPlayer.setVideoSurface(mSurfaceView.getHolder().getSurface());
            } else {
                startToPlay();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            if (mPlayer != null) {
                mPlayer.setSurfaceChanged();
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (mPlayer != null) {
                mPlayer.releaseVideoSurface();
            }
        }
    };

    private void startToPlay() {
        mPlayer = new AliVcMediaPlayer(this, mSurfaceView);
        mPlayer.setErrorListener(errorListener);
        mPlayer.setPreparedListener(preparedListener);
        mPlayer.setDefaultDecoder(0);//0表示硬解；1表示软解；
        mPlayer.setTimeout(5000);
        mPlayer.prepareAndPlay(msUri.toString());
    }

    AliVcMediaPlayer.MediaPlayerErrorListener errorListener = new MediaPlayer.MediaPlayerErrorListener() {
        @Override
        public void onError(int what, int extra) {
            LogUtils.e("视频播放错误码：" + what);
        }
    };
    MediaPlayer.MediaPlayerPreparedListener preparedListener = new MediaPlayer.MediaPlayerPreparedListener() {
        @Override
        public void onPrepared() {
            mPlayer.setVideoScalingMode(MediaPlayer.VideoScalingMode.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
            Handler mTimerHandler=new Handler();
            mTimerHandler.postDelayed(mUIRunnable, 100);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mPlayer.pause();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer != null) {
            mPlayer.play();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.destroy();
            mPlayer = null;
        }
        super.onDestroy();
    }

    Runnable mUIRunnable = new Runnable() {
        @Override
        public void run() {
            showUi(true);
        }
    };

    private void showUi(boolean isShow){
        if(isShow){
            llBot.setVisibility(View.VISIBLE);
        }
    }



    @OnClick({R.id.btn_Talk, R.id.btn_Message, R.id.btn_Gift, R.id.btn_Share, R.id.btn_Exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Talk:
                break;
            case R.id.btn_Message:
                break;
            case R.id.btn_Gift:
                break;
            case R.id.btn_Share:
                new ShareDialog(_activity, "分享标题", "分享内容",
                        "http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a995245582430320158247ca4890008@800h_1000w_1080x480", "").show();
                break;
            case R.id.btn_Exit:
                break;
        }
    }
}
