package com.huashitu.liveradio.adapter;

import android.content.Context;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.HotBean;
import java.util.List;


/**
 * 热门
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class Adapter_Hot extends BaseQuickAdapter {


    private Context context;

    public Adapter_Hot(Context context, List<HotBean> data) {
        super(R.layout.item_hotbot,data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {

    }
}
