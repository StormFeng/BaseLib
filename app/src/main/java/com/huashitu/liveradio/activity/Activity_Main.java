package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.huashitu.liveradio.R;
import com.huashitu.liveradio.fragment.Fragment_Home;
import com.huashitu.liveradio.fragment.Fragment_Person;
import com.midian.base.base.BaseFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 * Created by Administrator on 2016/11/10 0010.
 */

public class Activity_Main extends BaseFragmentActivity {

    private Fragment_Home fragmentHome;
    private Fragment_Person fragmentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentHome=new Fragment_Home();
        fragmentPerson=new Fragment_Person();
        switchFragment(fragmentHome);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.fragment;
    }
}
