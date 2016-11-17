package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.fragment.Fragment_Home;
import com.huashitu.liveradio.fragment.Fragment_Person;
import com.midian.base.app.AppManager;
import com.midian.base.base.BaseFragmentActivity;
import com.midian.base.util.UIHelper;
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

    private long waitTime = 2000;
    private long touchTime = 0;

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
        AppManager.getAppManager().finishActivity(Activity_Login.class);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if(event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
                long currentTime = System.currentTimeMillis();
                if((currentTime-touchTime)>=waitTime) {
                    UIHelper.t(_activity,"再按一次退出");
                    touchTime = currentTime;
                }else {
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
