package com.huashitu.liveradio.api;

import com.midian.base.api.BaseApiClient;
import com.midian.base.app.AppContext;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class ThisApiClient extends BaseApiClient {
    public ThisApiClient(AppContext ac) {
        super(ac);
    }
    static public void init(AppContext appcontext) {
        if (appcontext == null)
            return;
        appcontext.api.addApiClient(new ThisApiClient(appcontext));
    }
}
