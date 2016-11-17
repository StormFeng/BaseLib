package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.alibaba.livecloud.live.AlivcMediaFormat;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.fragment.Fragment_Home;
import com.huashitu.liveradio.fragment.Fragment_Person;
import com.midian.base.app.AppManager;
import com.midian.base.base.BaseFragmentActivity;
import com.midian.base.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 * Created by Administrator on 2016/11/10 0010.
 */

public class Activity_Main extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.iv_Camera)
    ImageView ivCamera;
    private Fragment_Home fragmentHome;
    private Fragment_Person fragmentPerson;

    private long waitTime = 2000;
    private long touchTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentHome = new Fragment_Home();
        fragmentPerson = new Fragment_Person();
        radioGroup.check(R.id.radio_Home);
        radioGroup.setOnCheckedChangeListener(this);
        switchFragment(fragmentHome);
        AppManager.getAppManager().finishActivity(Activity_Login.class);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radio_Home) {
            switchFragment(fragmentHome);
        } else {
            switchFragment(fragmentPerson);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime - touchTime) >= waitTime) {
                    UIHelper.t(_activity, "再按一次退出");
                    touchTime = currentTime;
                } else {
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.iv_Camera)
    public void onClick() {
        String rtmpUrl="rtmp://video-center.alivecdn.com/AppName/StreamName?vhost=test.example.com";
        int videoResolution = 1080;
        int cameraFrontFacing = AlivcMediaFormat.CAMERA_FACING_FRONT;
        int minBitrate = 500;
        int maxBitrate = 800;
        int bestBitrate = 600;
        int initBitrate = 600;
        int frameRate = 30;

        Activity_LiveRadio.RequestBuilder builder = new Activity_LiveRadio.RequestBuilder()
                .bestBitrate(bestBitrate)
                .cameraFacing(cameraFrontFacing)
                .rtmpUrl(rtmpUrl)
                .videoResolution(videoResolution)
                .minBitrate(minBitrate)
                .maxBitrate(maxBitrate)
                .frameRate(frameRate)
                .initBitrate(initBitrate);
        Activity_LiveRadio.startActivity(_activity, builder);
    }
}
