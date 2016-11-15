package com.huashitu.liveradio.datasource;

import android.content.Context;

import com.huashitu.liveradio.bean.DayListBean;
import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class DayListDataRecource extends BaseListDataSource{


    public DayListDataRecource(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> beans=new ArrayList<>();
        if(page==1){
            DayListBean bean=new DayListBean();
            bean.setItemViewType(0);
            beans.add(bean);
        }
        for(int i=0;i<10;i++){
            DayListBean bean=new DayListBean();
            bean.setItemViewType(1);
            beans.add(bean);
        }
        hasMore=false;
        return beans;
    }
}
