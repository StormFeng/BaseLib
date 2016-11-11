package com.huashitu.liveradio.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.NearbyBean;
import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class Adapter_Nearby extends BaseQuickAdapter<NearbyBean> {


    public Adapter_Nearby(List<NearbyBean> data) {
        super(R.layout.item_nearby, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NearbyBean nearbyBean) {

    }
}
