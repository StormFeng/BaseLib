package com.huashitu.liveradio.datasource;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;


/**
 * 热门
 */
public class FragmentHotDataResource extends BaseListDataSource {

    public FragmentHotDataResource(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> models = new ArrayList<>();
        if(page==1){
            NetResult netResult = new NetResult();
            netResult.setItemViewType(0);
            models.add(netResult);
        }
        for(int i=0;i<10;i++){
            NetResult netResult = new NetResult();
            netResult.setItemViewType(1);
            models.add(netResult);
        }
        hasMore=false;
        return models;
    }
}
