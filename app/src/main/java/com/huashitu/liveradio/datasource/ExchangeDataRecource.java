package com.huashitu.liveradio.datasource;

import android.content.Context;

import com.huashitu.liveradio.bean.DayListBean;
import com.huashitu.liveradio.bean.ExchangeBean;
import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 * 兑换
 * Created by Administrator on 2016/11/15 0015.
 */

public class ExchangeDataRecource extends BaseListDataSource{


    public ExchangeDataRecource(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> beans=new ArrayList<>();
        if(page==1){
            ExchangeBean bean=new ExchangeBean();
            bean.setItemViewType(0);
            beans.add(bean);
        }
        for(int i=0;i<10;i++){
            ExchangeBean bean=new ExchangeBean();
            bean.setItemViewType(1);
            beans.add(bean);
        }
        hasMore=false;
        return beans;
    }
}
