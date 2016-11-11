package com.huashitu.liveradio.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.huashitu.liveradio.R;
import com.huashitu.liveradio.fragment.Fragment_Home;
import com.huashitu.liveradio.fragment.Fragment_Person;
import com.jaeger.library.StatusBarUtil;
import com.midian.base.base.BaseFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 * Created by Administrator on 2016/11/10 0010.
 */

public class Activity_Main extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private Fragment_Home fragmentHome;
    private Fragment_Person fragmentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentHome = new Fragment_Home();
        fragmentPerson = new Fragment_Person();
        radioGroup.check(R.id.radio_Home);
        radioGroup.setOnCheckedChangeListener(this);
        switchFragment(fragmentHome);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.radio_Home){
            switchFragment(fragmentHome);
        }else{
            switchFragment(fragmentPerson);
        }
    }
}
