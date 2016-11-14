package com.huashitu.liveradio.app;

import com.huashitu.liveradio.api.ThisApiClient;
import com.midian.base.app.AppContext;
import com.midian.base.util.ShareUtil;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class BaseApplication extends AppContext {
    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtil.init();
        ThisApiClient.init(this);
    }
}
