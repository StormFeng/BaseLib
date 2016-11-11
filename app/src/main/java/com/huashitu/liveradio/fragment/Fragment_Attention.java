package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.adapter.Adapter_Attention;
import com.huashitu.liveradio.adapter.Adapter_Nearby;
import com.huashitu.liveradio.bean.AttentionBean;
import com.huashitu.liveradio.bean.NearbyBean;
import com.huashitu.liveradio.dao.Dao;
import com.midian.base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关注
 * Created by Administrator on 2016/11/10 0010.
 */

public class Fragment_Attention extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private int PAGE_SIZE=10;
    private int page=1;
    private Adapter_Attention adapterAttention;
    private List<AttentionBean> beans=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attention, null);
        ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init() {
        swipeLayout.setOnRefreshListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager(_activity));
        adapterAttention=new Adapter_Attention(beans);
        View v= LayoutInflater.from(_activity).inflate(R.layout.layout_noattention,null);
        adapterAttention.setEmptyView(v);
        adapterAttention.setOnLoadMoreListener(this);
        adapterAttention.openLoadMore(5,true);
        adapterAttention.notifyDataChangedAfterLoadMore(Dao.getAttentionBean(page),true);
        recycleView.setAdapter(adapterAttention);
    }

    @Override
    public void onRefresh() {
        LogUtils.e("onRefresh");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapterAttention.notifyDataChangedAfterLoadMore(Dao.getAttentionBean(page),true);
            }
        }, 1000);
    }

    @Override
    public void onLoadMoreRequested() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapterAttention.notifyDataChangedAfterLoadMore(Dao.getAttentionBean(page),true);
            }
        }, 1000);
    }
}
