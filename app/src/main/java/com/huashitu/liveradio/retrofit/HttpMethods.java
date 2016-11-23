package com.huashitu.liveradio.retrofit;

import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.bean.HotBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public class HttpMethods {

    public static final String BASE_URL = "http://live.9158.com/Fans/";
    private static int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private HttpService httpService;

    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        httpService = retrofit.create(HttpService.class);
    }

    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private class HttpResultFunc<T> implements Func1<HttpResult<T>,T>{

        @Override
        public T call(HttpResult<T> tHttpResult) {
            if(!"100".equals(tHttpResult.getCode())){
                try {
                    throw new Exception(tHttpResult.getMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return tHttpResult.getData();
        }
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 热门主播
     * @param subscriber
     */
    public void getHotLiveRadio(Subscriber<HotBean> subscriber){
        Map<String,String> map=new HashMap<>();
        map.put("page","1");
        LogUtils.e(map);
        Observable<HotBean> observable = httpService.getHotLiveRadio(map)
                .map(new HttpResultFunc<HotBean>());
        toSubscribe(observable,subscriber);
        LogUtils.e("getHotLiveRadio");
    }
}
