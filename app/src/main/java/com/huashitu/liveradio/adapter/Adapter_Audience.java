package com.huashitu.liveradio.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.AudienceBean;
import com.huashitu.liveradio.widget.DialogAudienceDetail;

import java.util.List;

/**
 * 观众
 * Created by Administrator on 2016/11/22 0022.
 */

public class Adapter_Audience extends BaseQuickAdapter{

    private Context context;

    public Adapter_Audience(Context context,List<AudienceBean> data) {
        super(R.layout.item_audience, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {
        baseViewHolder.setOnClickListener(R.id.iv_Head, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogAudienceDetail(context).show();
            }
        });
    }
}
