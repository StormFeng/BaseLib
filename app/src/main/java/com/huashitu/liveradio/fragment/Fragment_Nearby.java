package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.adapter.Adapter_Nearby;
import com.huashitu.liveradio.bean.NearbyBean;
import com.midian.base.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 附近
 * Created by Administrator on 2016/11/10 0010.
 */

public class Fragment_Nearby extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private Adapter_Nearby adapterNearby;
    private List<NearbyBean> beans=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nearby, null);
        ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init() {
//        for(int i=0;i<20;i++){
//            beans.add(new NearbyBean());
//        }
        swipeLayout.setOnRefreshListener(this);
        recycleView.setLayoutManager(new GridLayoutManager(_activity,3,LinearLayoutManager.VERTICAL,false));
        adapterNearby=new Adapter_Nearby(beans);
        View v=LayoutInflater.from(_activity).inflate(R.layout.layout_nodata,null);
        View vv=LayoutInflater.from(_activity).inflate(R.layout.item_nearbytop,null);
        if(beans.size()>0){
            adapterNearby.addHeaderView(vv);
        }
        adapterNearby.setEmptyView(v);
        recycleView.setAdapter(adapterNearby);
    }

    @Override
    public void onRefresh() {

    }
}
