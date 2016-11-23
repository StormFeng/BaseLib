package com.huashitu.liveradio.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.AudienceBean;

import java.util.List;

/**
 * 观众
 * Created by Administrator on 2016/11/22 0022.
 */

public class Adapter_Audience extends BaseQuickAdapter{

    public Adapter_Audience(List<AudienceBean> data) {
        super(R.layout.item_audience, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {

    }
}
