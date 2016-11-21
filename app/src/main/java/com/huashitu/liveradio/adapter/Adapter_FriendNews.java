package com.huashitu.liveradio.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.bean.FriendNewsBean;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class Adapter_FriendNews extends BaseQuickAdapter{

    public Adapter_FriendNews(List<FriendNewsBean> data) {
        super(R.layout.item_news_friend,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {

    }
}
