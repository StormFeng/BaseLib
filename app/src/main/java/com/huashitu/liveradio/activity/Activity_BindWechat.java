package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.widget.Button;

import com.huashitu.liveradio.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 绑定微信
 * Created by Administrator on 2016/11/16 0016.
 */

public class Activity_BindWechat extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.btn_Bind)
    Button btnBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindwechat);
        ButterKnife.bind(this);

        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("首次领取账号绑定");
        topbar.setBackgroundResource(R.drawable.icon_topbar_bg);
    }

    @OnClick(R.id.btn_Bind)
    public void onClick() {

    }
}
