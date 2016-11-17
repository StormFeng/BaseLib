package com.huashitu.liveradio.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huashitu.liveradio.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class DayListTpl extends BaseTpl<NetResult> {

    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.tv_Ranking)
    TextView tvRanking;
    @BindView(R.id.iv_Head)
    RoundedImageView ivHead;
    @BindView(R.id.ll_Normal)
    LinearLayout llNormal;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.iv_Sex)
    ImageView ivSex;
    @BindView(R.id.tv_Grade)
    TextView tvGrade;
    @BindView(R.id.tv_Contribution)
    TextView tvContribution;
    @BindView(R.id.ll_Num2)
    LinearLayout llNum2;
    @BindView(R.id.iiv_Head)
    RoundedImageView iivHead;
    @BindView(R.id.ttv_Name)
    TextView ttvName;
    @BindView(R.id.iiv_Sex)
    ImageView iivSex;
    @BindView(R.id.ttv_Grade)
    TextView ttvGrade;
    @BindView(R.id.ttv_Contribution)
    TextView ttvContribution;
    @BindView(R.id.ll_Num1)
    LinearLayout llNum1;
    @BindView(R.id.iv_HeadBg)
    ImageView ivHeadBg;

    public DayListTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DayListTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_daylist;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        ttvContribution.setText(position+"");
        tvContribution.setText(position+"");
        if (position == 1) {
            llNum1.setVisibility(VISIBLE);
            llNum2.setVisibility(GONE);
        } else if (position == 2) {
            llNum1.setVisibility(GONE);
            llNum2.setVisibility(VISIBLE);
            rlTop.setVisibility(VISIBLE);
            llNormal.setVisibility(GONE);
            ivHeadBg.setBackgroundResource(R.drawable.icon_no2);
        } else if (position == 3) {
            llNum1.setVisibility(GONE);
            llNum2.setVisibility(VISIBLE);
            rlTop.setVisibility(VISIBLE);
            llNormal.setVisibility(GONE);
            ivHeadBg.setBackgroundResource(R.drawable.icon_no3);
        } else {
            llNum1.setVisibility(GONE);
            llNum2.setVisibility(VISIBLE);
            rlTop.setVisibility(GONE);
            llNormal.setVisibility(VISIBLE);
            tvRanking.setText("No."+position);
        }
    }
}
