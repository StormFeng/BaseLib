package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.activity.Activity_WatchRadio;
import com.huashitu.liveradio.adapter.Adapter_Attention;
import com.huashitu.liveradio.adapter.Adapter_Hot;
import com.huashitu.liveradio.bean.AttentionBean;
import com.huashitu.liveradio.dao.Dao;
import com.midian.base.base.BaseFragment;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 热门
 * Created by Administrator on 2016/11/10 0010.
 */

public class Fragment_Hot extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnRecyclerViewItemClickListener {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private Banner banner;

    private Adapter_Hot adapterHot;
    private List<Integer> images=new ArrayList<>();
    private View topItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attention, null);
        ButterKnife.bind(this, v);
        topItem=inflater.inflate(R.layout.item_hottop, null);
        init();
        return v;
    }

    private void init(){
        recycleView.setLayoutManager(new LinearLayoutManager(_activity));
        adapterHot = new Adapter_Hot(_activity, Dao.getHotBean());
        banner = (Banner) topItem.findViewById(R.id.banner);
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(5000);//设置轮播间隔时间
        for (int i = 0; i < 3; i++) {
            images.add(R.drawable.icon_banner);
        }
        banner.setImages(images.toArray());
        adapterHot.addHeaderView(topItem,0);
        recycleView.setAdapter(adapterHot);
        adapterHot.setOnRecyclerViewItemClickListener(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(View view, int i) {
        LogUtils.e(i);
        UIHelper.jump(_activity, Activity_WatchRadio.class);
    }
}
