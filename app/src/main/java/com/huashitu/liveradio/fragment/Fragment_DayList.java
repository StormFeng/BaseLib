package com.huashitu.liveradio.fragment;

import com.huashitu.liveradio.datasource.DayListDataRecource;
import com.huashitu.liveradio.tpl.DayListTopTpl;
import com.huashitu.liveradio.tpl.DayListTpl;
import com.midian.base.base.BaseMultiTypeListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataAdapter;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import java.util.ArrayList;

/**
 * 日榜
 * Created by Administrator on 2016/11/15 0015.
 */

public class Fragment_DayList extends BaseMultiTypeListFragment {

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new DayListDataRecource(_activity);
    }

    @Override
    protected ArrayList<Class> getTemplateClasses() {
        ArrayList<Class> tpls=new ArrayList<>();
        tpls.add(DayListTopTpl.class);
        tpls.add(DayListTpl.class);
        return tpls;
    }

    @Override
    public void onEndRefresh(IDataAdapter adapter, Object result) {

    }

    @Override
    public void onEndLoadMore(IDataAdapter adapter, Object result) {

    }
}
