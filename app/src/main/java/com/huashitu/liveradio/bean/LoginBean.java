package com.huashitu.liveradio.bean;

import com.google.gson.JsonSyntaxException;
import com.midian.base.app.AppException;
import com.midian.base.bean.NetResult;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class LoginBean extends NetResult {
    /**
     * content : {"phone":"18993399470","tokenTime":"2016-11-15 10:19:28","id":89,"account":"18993399470","token":"d72da2253e2e92988ee40a8fc1e0cd20"}
     */

    private Content content;

    public static ActivitiesBean parse(String json) throws AppException {
        ActivitiesBean res = new ActivitiesBean();
        try {
            res = gson.fromJson(json, ActivitiesBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw AppException.json(e);
        }
        return res;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }


    public class Content {
        /**
         * phone : 18993399470
         * tokenTime : 2016-11-15 10:19:28
         * id : 89
         * account : 18993399470
         * token : d72da2253e2e92988ee40a8fc1e0cd20
         */

        private String phone;
        private String tokenTime;
        private String id;
        private String account;
        private String token;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getTokenTime() {
            return tokenTime;
        }

        public void setTokenTime(String tokenTime) {
            this.tokenTime = tokenTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
