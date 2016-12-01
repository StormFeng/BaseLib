package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.activity.Activity_WatchRadio;
import com.huashitu.liveradio.adapter.Adapter_Attention;
import com.huashitu.liveradio.adapter.Adapter_Hot;
import com.huashitu.liveradio.api.AppUtil;
import com.huashitu.liveradio.bean.AttentionBean;
import com.huashitu.liveradio.bean.HotBean;
import com.huashitu.liveradio.dao.Dao;
import com.huashitu.liveradio.retrofit.BaseSubcriber;
import com.huashitu.liveradio.retrofit.HttpMethods;
import com.midian.base.api.ApiCallback;
import com.midian.base.base.BaseFragment;
import com.midian.base.bean.NetResult;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * 热门
 * Created by Administrator on 2016/11/10 0010.
 */

public class Fragment_Hot extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, Banner.OnBannerClickListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private Banner banner;
    private Adapter_Hot adapterHot;
    private List<Integer> images=new ArrayList<>();
    private List<HotBean.ListBean> hotBeans=new ArrayList<>();
    private View topItem;
    private int page=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attention, null);
        ButterKnife.bind(this, v);
        topItem=inflater.inflate(R.layout.item_hottop, null);
        init();
        return v;
    }

    private void init(){
        HttpMethods.getInstance().getHotLiveRadio(new RefreshSubscriber(),page);
        recycleView.setLayoutManager(new LinearLayoutManager(_activity));
        swipeLayout.setOnRefreshListener(this);
        adapterHot = new Adapter_Hot(_activity, hotBeans);
        banner = (Banner) topItem.findViewById(R.id.banner);
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(5000);//设置轮播间隔时间
        banner.setOnBannerClickListener(this);
        for (int i = 0; i < 3; i++) {
            images.add(R.drawable.icon_banner);
        }
        banner.setImages(images.toArray());
        adapterHot.addHeaderView(topItem,0);
        adapterHot.openLoadAnimation();
        adapterHot.openLoadMore(20,true);
        adapterHot.setOnLoadMoreListener(this);
        recycleView.setAdapter(adapterHot);
    }

    @Override
    public void onLoadMoreRequested() {
        HttpMethods.getInstance().getHotLiveRadio(new OnLoadMoreSubscriber(),++page);
    }

    private class RefreshSubscriber extends BaseSubcriber{
        @Override
        public void onNext(Object o) {
            super.onNext(o);
            swipeLayout.setRefreshing(false);
            HotBean bean = (HotBean) o;
            hotBeans=bean.getList();
            adapterHot.setNewData(hotBeans);
        }
    }

    private class OnLoadMoreSubscriber extends BaseSubcriber{
        @Override
        public void onNext(Object o) {
            super.onNext(o);
            List<HotBean.ListBean> list = ((HotBean) o).getList();
            adapterHot.notifyDataChangedAfterLoadMore(list,true);
            if(list.size()<20){
                adapterHot.notifyDataChangedAfterLoadMore(false);
            }

        }
    }


    @Override
    public void onRefresh() {
        page=1;
        HttpMethods.getInstance().getHotLiveRadio(new RefreshSubscriber(),1);
    }

    @Override
    public void OnBannerClick(View view, int position) {
    }
}
