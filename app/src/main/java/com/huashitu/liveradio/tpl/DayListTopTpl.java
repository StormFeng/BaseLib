package com.huashitu.liveradio.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.huashitu.liveradio.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class DayListTopTpl extends BaseTpl<NetResult> {

    public DayListTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DayListTopTpl(Context context) {
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
