package com.huashitu.liveradio.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.huashitu.liveradio.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class AllListTopTpl extends BaseTpl<NetResult> {

    public AllListTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AllListTopTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_topdaylist;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
