package com.huashitu.liveradio.api;

import com.huashitu.liveradio.bean.LoginBean;
import com.midian.base.afinal.http.AjaxParams;
import com.midian.base.api.ApiCallback;
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

    public void login(String phone,String code,ApiCallback callback){
        AjaxParams params = new AjaxParams();
        params.put("clientKey", ac.getClientKey());
        params.put("phone", phone);
        params.put("deviceToken", ac.device_token);
        params.put("code", code);
        params.put("token", ac.access_token);

        post(callback,Constant.LOGIN, params, LoginBean.class,
                getMethodName(Thread.currentThread().getStackTrace()));
    }

}
