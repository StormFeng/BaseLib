package com.huashitu.liveradio.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huashitu.liveradio.R;
import com.huashitu.liveradio.adapter.Adapter_FriendNews;
import com.huashitu.liveradio.bean.FriendNewsBean;
import com.midian.base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class Fragment_Friend extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    private List<FriendNewsBean> beans=new ArrayList<>();
    private Adapter_FriendNews adapterFriendNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend, null);
        ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init(){
        recycleView.setLayoutManager(new LinearLayoutManager(_activity));
        for(int i=0;i<10;i++){
            beans.add(new FriendNewsBean());
        }
        adapterFriendNews=new Adapter_FriendNews(beans);
        recycleView.setAdapter(adapterFriendNews);
    }
}
