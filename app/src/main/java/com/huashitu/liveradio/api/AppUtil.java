package com.huashitu.liveradio.api;

import com.huashitu.liveradio.app.BaseApplication;
import com.midian.base.app.AppContext;

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
