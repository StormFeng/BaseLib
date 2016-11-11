package com.huashitu.liveradio.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.huashitu.liveradio.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 热门
 */
public class Fragment_HotBotTpl extends BaseTpl<NetResult> {

    @BindView(R.id.iv_Head)
    RoundedImageView ivHead;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.tv_Count)
    TextView tvCount;
    @BindView(R.id.tv_Adress)
    TextView tvAdress;
    @BindView(R.id.tv_State)
    TextView tvState;
    @BindView(R.id.iv_Bg)
    ImageView ivBg;
    @BindView(R.id.tv_Type)
    TextView tvType;

    public Fragment_HotBotTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Fragment_HotBotTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_hotbot;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
