package com.huashitu.liveradio.fragment;

import com.huashitu.liveradio.datasource.AllListDataRecource;
import com.huashitu.liveradio.tpl.AllListTopTpl;
import com.huashitu.liveradio.tpl.AllListTpl;
import com.midian.base.base.BaseMultiTypeListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataAdapter;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import java.util.ArrayList;

/**
 * 总榜
 * Created by Administrator on 2016/11/15 0015.
 */

public class Fragment_AllList extends BaseMultiTypeListFragment{

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new AllListDataRecource(_activity);
    }

    @Override
    protected ArrayList<Class> getTemplateClasses() {
        ArrayList<Class> tpls=new ArrayList<>();
        tpls.add(AllListTopTpl.class);
        tpls.add(AllListTpl.class);
        return tpls;
    }

    @Override
    public void onEndRefresh(IDataAdapter adapter, Object result) {

    }

    @Override
    public void onEndLoadMore(IDataAdapter adapter, Object result) {

    }
}
