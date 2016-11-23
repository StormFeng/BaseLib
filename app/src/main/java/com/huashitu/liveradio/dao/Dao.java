package com.huashitu.liveradio.dao;

import com.huashitu.liveradio.bean.AttentionBean;
import com.huashitu.liveradio.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class Dao {

    public static List<AttentionBean> getAttentionBean(int page){
        List<AttentionBean> beans=new ArrayList<>();
        if(page<5){
            for(int i=0;i<5;i++){
                beans.add(new AttentionBean());
            }
        }
        return beans;
    }

//    public static List<HotBean> getHotBean(){
//        List<HotBean> beans=new ArrayList<>();
//        HotBean item=new HotBean();
//        item.setItemType(0);
//        beans.add(item);
//        for(int i=0;i<20;i++){
//            HotBean bean=new HotBean();
//            bean.setItemType(1);
//            beans.add(bean);
//        }
//        return beans;
//    }
}
