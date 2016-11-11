package com.huashitu.liveradio.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.AttentionBean;

import java.util.List;

/**
 * 关注
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class Adapter_Attention extends BaseQuickAdapter<AttentionBean> {


    public Adapter_Attention(List<AttentionBean> data) {
        super(R.layout.item_attention, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AttentionBean attentionBean) {

    }
}
