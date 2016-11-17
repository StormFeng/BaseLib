package com.huashitu.liveradio.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.datasource.ExchangeDataRecource;
import com.huashitu.liveradio.tpl.ExchangeTopTpl;
import com.huashitu.liveradio.tpl.ExchangeTpl;
import com.huashitu.liveradio.widget.DialogCustom;
import com.midian.base.base.BaseMultiTypeListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataAdapter;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

/**
 * 兑换
 * Created by Administrator on 2016/11/16 0016.
 */

public class Activity_Exchange extends BaseMultiTypeListActivity {

    private BaseLibTopbarView topbar;
    private Button btnCustom;
    private DialogCustom dialogCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topbar=findView(R.id.topbar);
        topbar.setTitle("兑换");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setBackgroundResource(R.drawable.icon_topbar_bg);
        btnCustom=findView(R.id.btn_Custom);
        btnCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        super.onClick(arg0);
        switch (arg0.getId()){
            case R.id.btn_ok:
                UIHelper.t(_activity,"确定");
                break;
            case R.id.btn_Custom:
                dialogCustom=new DialogCustom(_activity);
                dialogCustom.show();
                dialogCustom.getOkButton().setOnClickListener(this);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exchange;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ExchangeDataRecource(_activity);
    }

    @Override
    protected ArrayList<Class> getTemplateClasses() {
        listView.setDivider(null);
        ArrayList<Class> tpls=new ArrayList<>();
        tpls.add(ExchangeTopTpl.class);
        tpls.add(ExchangeTpl.class);
        return tpls;
    }

    @Override
    public void onEndRefresh(IDataAdapter adapter, Object result) {

    }

    @Override
    public void onEndLoadMore(IDataAdapter adapter, Object result) {

    }
}
