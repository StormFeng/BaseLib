package com.huashitu.liveradio.retrofit;

import com.huashitu.liveradio.bean.HotBean;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public interface HttpService {

    /**
     * 热门主播
     * @param options
     * @return
     */
    @GET("GetHotLive")
    Observable<HttpResult<HotBean>> getHotLiveRadio(@QueryMap Map<String,String> options);
}
