package com.huashitu.liveradio.api;

import com.huashitu.liveradio.app.BaseApplication;
import com.huashitu.liveradio.bean.HotBean;
import com.midian.base.afinal.http.AjaxParams;
import com.midian.base.api.ApiCallback;
import com.midian.base.app.AppContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static com.midian.base.api.BaseApiClient.getMethodName;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class AppUtil {
    public static BaseApplication getAppContext(AppContext ac) {
        return (BaseApplication) ac;
    }

    public static ThisApiClient getApiClient(AppContext ac) {
        return ac.api.getApiClient(ThisApiClient.class);
    }
}
