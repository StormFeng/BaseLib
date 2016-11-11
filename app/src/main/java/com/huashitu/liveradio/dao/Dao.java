package com.huashitu.liveradio.dao;

import com.huashitu.liveradio.bean.AttentionBean;

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
}
