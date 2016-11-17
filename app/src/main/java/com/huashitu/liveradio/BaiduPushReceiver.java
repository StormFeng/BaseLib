package com.huashitu.liveradio;

import android.content.Context;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.midian.base.app.AppContext;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class BaiduPushReceiver extends PushMessageReceiver {

    private AppContext ac;

    @Override
    public void onBind(Context context, int errorCode, String appid, String userId, String channelId, String requestId) {
        ac = (AppContext) context.getApplicationContext();
        String responseString = "onBind errorCode=" + errorCode + " appid=" + appid + " userId=" + userId + " channelId=" + channelId
                + " requestId=" + requestId;
        LogUtils.e(TAG, responseString);
        if (errorCode == 0) {
            // 绑定成功
			((AppContext) context.getApplicationContext()).saveDeviceToken(channelId);
            ac.saveDeviceToken(channelId);
            System.out.println("百度云推送绑定成功;:::channelId=" + channelId);
        }
    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    @Override
    public void onMessage(Context context, String s, String s1) {

    }

    @Override
    public void onNotificationClicked(Context context, String s, String s1, String s2) {

    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {

    }
}
