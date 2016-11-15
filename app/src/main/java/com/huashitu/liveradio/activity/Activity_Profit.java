package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huashitu.liveradio.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class Activity_Profit extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tv_Profit)
    TextView tvProfit;
    @BindView(R.id.tv_Tip)
    TextView tvTip;
    @BindView(R.id.btn_Exchange)
    Button btnExchange;
    @BindView(R.id.btn_ReceiveTip)
    Button btnReceiveTip;
    @BindView(R.id.tv_CommonProblem)
    TextView tvCommonProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit);
        ButterKnife.bind(this);
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("我的收益");
        topbar.setRightText("领取记录",null);
    }

    @OnClick({R.id.btn_Exchange, R.id.btn_ReceiveTip, R.id.tv_CommonProblem})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Exchange:
                break;
            case R.id.btn_ReceiveTip:
                break;
            case R.id.tv_CommonProblem:
                break;
        }
    }
}
