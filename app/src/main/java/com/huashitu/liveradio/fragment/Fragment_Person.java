package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huashitu.liveradio.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.midian.base.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class Fragment_Person extends BaseFragment {
    @BindView(R.id.iv_Search)
    ImageView ivSearch;
    @BindView(R.id.iv_Message)
    ImageView ivMessage;
    @BindView(R.id.iv_Head)
    RoundedImageView ivHead;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.iv_Sex)
    ImageView ivSex;
    @BindView(R.id.iv_Grade)
    TextView ivGrade;
    @BindView(R.id.iv_Edit)
    ImageView ivEdit;
    @BindView(R.id.iv_Account)
    TextView ivAccount;
    @BindView(R.id.tv_Sign)
    TextView tvSign;
    @BindView(R.id.ll_Top)
    LinearLayout llTop;
    @BindView(R.id.ll_LiveRadio)
    LinearLayout llLiveRadio;
    @BindView(R.id.ll_Attention)
    LinearLayout llAttention;
    @BindView(R.id.ll_Fans)
    LinearLayout llFans;
    @BindView(R.id.v_Contribution)
    TextView vContribution;
    @BindView(R.id.v_Profit)
    LinearLayout vProfit;
    @BindView(R.id.v_Account)
    LinearLayout vAccount;
    @BindView(R.id.v_Grade)
    LinearLayout vGrade;
    @BindView(R.id.v_Setting)
    TextView vSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({R.id.iv_Search, R.id.iv_Message, R.id.ll_Top, R.id.ll_LiveRadio, R.id.ll_Attention, R.id.ll_Fans, R.id.v_Contribution, R.id.v_Profit, R.id.v_Account, R.id.v_Grade, R.id.v_Setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_Search:
                break;
            case R.id.iv_Message:
                break;
            case R.id.ll_Top:
                break;
            case R.id.ll_LiveRadio:
                break;
            case R.id.ll_Attention:
                break;
            case R.id.ll_Fans:
                break;
            case R.id.v_Contribution:
                break;
            case R.id.v_Profit:
                break;
            case R.id.v_Account:
                break;
            case R.id.v_Grade:
                break;
            case R.id.v_Setting:
                break;
        }
    }
}
