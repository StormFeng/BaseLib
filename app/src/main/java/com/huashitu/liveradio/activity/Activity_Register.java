package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.huashitu.liveradio.R;
import com.huashitu.liveradio.api.AppUtil;
import com.huashitu.liveradio.widget.BaseToast;
import com.midian.base.api.ApiCallback;
import com.midian.base.base.BaseActivity;
import com.midian.base.bean.NetResult;
import com.midian.base.util.AnimatorUtils;
import com.midian.base.util.FormatUtils;
import com.midian.base.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册
 * Created by Administrator on 2016/11/10 0010.
 */

public class Activity_Register extends BaseActivity {
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.et_Phone)
    EditText etPhone;
    @BindView(R.id.et_Code)
    EditText etCode;
    @BindView(R.id.btn_Code)
    Button btnCode;
    @BindView(R.id.et_Pass)
    EditText etPass;
    @BindView(R.id.btn_Register)
    Button btnRegister;

    private String phone;
    private String pass;
    private String code;

    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_Code, R.id.btn_Register})
    public void onClick(View view) {
        pass=etPass.getText().toString();
        phone=etPhone.getText().toString();
        code=etCode.getText().toString();
        switch (view.getId()) {
            case R.id.btn_Code:
                if(ifPhoneRight()){
                    String type="1";
                    AppUtil.getApiClient(ac).sendCode(phone,type,this);
                }
                break;
            case R.id.btn_Register:
                if(ifAvaliable()){
                    AppUtil.getApiClient(ac).register(phone,pass,code,this);
                }
                break;
        }
    }

    @Override
    public void onApiSuccess(NetResult res, String tag) {
        if(res.isOK()){
            if("sendCode".equals(tag)){
                downTime();
                UIHelper.t(_activity,"验证码已发送至手机");
            }else if("register".equals(tag)){
                UIHelper.t(_activity,"注册成功");
                finish();
            }
        }else{
            ac.handleErrorCode(_activity,res.getRet_info());
        }
    }

    private void downTime() {
        mCountDownTimer = new CountDownTimer(59 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeText = "秒后重发";
                btnCode.setBackgroundResource(R.drawable.radius_8_grey);
                btnCode.setClickable(false);
                btnCode
                        .setText(millisUntilFinished / 1000 + timeText);
            }

            @Override
            public void onFinish() {
                btnCode.setBackgroundResource(R.drawable.radius_8_purple);
                btnCode.setClickable(true);
                btnCode.setText("验证码");
            }
        };
        mCountDownTimer.start();
    }

    private boolean ifPhoneRight(){
        if("".equals(phone)){
            AnimatorUtils.onVibrationView(etPhone);
            BaseToast.show(_activity,"请输入手机号");
            return false;
        }
        if(!FormatUtils.isMobile(phone)){
            AnimatorUtils.onVibrationView(etPhone);
            BaseToast.show(_activity,"手机号格式不正确");
            return false;
        }
        return true;
    }

    private boolean ifAvaliable() {
        if("".equals(phone)){
            AnimatorUtils.onVibrationView(etPhone);
            BaseToast.show(_activity,"请输入手机号");
            return false;
        }
        if(!FormatUtils.isMobile(phone)){
            AnimatorUtils.onVibrationView(etPhone);
            BaseToast.show(_activity,"手机号格式不正确");
            return false;
        }
        if("".equals(code)){
            AnimatorUtils.onVibrationView(etCode);
            BaseToast.show(_activity,"请输入验证码");
            return false;
        }
        if("".equals(pass)){
            AnimatorUtils.onVibrationView(etPass);
            BaseToast.show(_activity,"请输入密码");
            return false;
        }
        return true;
    }
}
