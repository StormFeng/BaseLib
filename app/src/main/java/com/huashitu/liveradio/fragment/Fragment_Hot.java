package com.huashitu.liveradio.fragment;

import com.huashitu.liveradio.datasource.FragmentHotDataResource;
import com.huashitu.liveradio.tpl.Fragment_HotBotTpl;
import com.huashitu.liveradio.tpl.Fragment_HotTopTpl;
import com.midian.base.base.BaseMultiTypeListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataAdapter;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import java.util.ArrayList;

/**
 * 热门
 * Created by Administrator on 2016/11/11 0011.
 */

public class Fragment_Hot extends BaseMultiTypeListFragment {

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FragmentHotDataResource(_activity);
    }

    @Override
    protected ArrayList<Class> getTemplateClasses() {
        listView.setDivider(null);
        ArrayList<Class> tpls=new ArrayList<>();
        tpls.add(Fragment_HotTopTpl.class);
        tpls.add(Fragment_HotBotTpl.class);
        return tpls;
    }

    @Override
    public void onEndRefresh(IDataAdapter adapter, Object result) {

    }

    @Override
    public void onEndLoadMore(IDataAdapter adapter, Object result) {

    }
}
