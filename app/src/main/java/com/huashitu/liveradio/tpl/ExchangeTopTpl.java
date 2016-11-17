package com.huashitu.liveradio.tpl;

import android.content.Context;
import android.util.AttributeSet;
import com.huashitu.liveradio.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class ExchangeTopTpl extends BaseTpl<NetResult> {

    public ExchangeTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExchangeTopTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_exchangetop;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
