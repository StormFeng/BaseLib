package com.huashitu.liveradio.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.alivc.player.AliVcMediaPlayer;
import com.alivc.player.MediaPlayer;
import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.adapter.Adapter_Audience;
import com.huashitu.liveradio.bean.AudienceBean;
import com.huashitu.liveradio.widget.DialogFragmentTalk;
import com.huashitu.liveradio.widget.DialogSendMessage;
import com.huashitu.liveradio.widget.ShareDialog;
import com.midian.base.base.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 观看别人直播
 * Created by Administrator on 2016/11/18 0018.
 */

public class Activity_WatchRadio extends BaseFragmentActivity{

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
    @BindView(R.id.ll_UI)
    LinearLayout llUI;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.ll_BotButton)
    LinearLayout llBotButton;

    private SurfaceHolder mSurfaceHolder;
    private AliVcMediaPlayer mPlayer;
    private String msUri = "http://hdl.9158.com/live/8c3321184dfdb8c0ba2b940d13e48b33.flv";
    private List<AudienceBean> audienceBeans = new ArrayList<>();
    private Adapter_Audience adapterAudience;
//    private String msUri = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
        setContentView(R.layout.activity_watchradio);
        ButterKnife.bind(this);
        msUri = mBundle.getString("url");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(_activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(linearLayoutManager);
        for (int i = 0; i < 10; i++) {
            audienceBeans.add(new AudienceBean());
        }
        adapterAudience = new Adapter_Audience(_activity, audienceBeans);
        recycleView.setAdapter(adapterAudience);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(mSurfaceHolderCB);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

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
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    mSurfaceView.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                }
            });
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mPlayer != null) {
                mPlayer.pause();
            }
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


    @OnClick({R.id.btn_Talk, R.id.btn_Message, R.id.btn_Gift, R.id.btn_Share, R.id.btn_Exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Talk:
                DialogSendMessage dialogSendMessage = new DialogSendMessage(_activity);
                dialogSendMessage.show();
                final EditText etContent = dialogSendMessage.getEtContent();
                etContent.getShowSoftInputOnFocus();
                etContent.requestFocus();
                break;
            case R.id.btn_Message:
                new DialogFragmentTalk().show(fm, "btn_Message");
                break;
            case R.id.btn_Gift:
                break;
            case R.id.btn_Share:
                new ShareDialog(_activity, "分享标题", "分享内容",
                        "http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a995245582430320158247ca4890008@800h_1000w_1080x480", "").show();
                break;
            case R.id.btn_Exit:
                finish();
                break;
        }
    }
}
