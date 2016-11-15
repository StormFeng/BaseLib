package com.huashitu.liveradio.bean;

import com.google.gson.JsonSyntaxException;
import com.midian.base.app.AppException;
import com.midian.base.bean.NetResult;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class SendCodeBean extends NetResult {

    /**
     * content : {"code":"2723","phone":"18993399470"}
     */

    private Content content;

    public static SendCodeBean parse(String json) throws AppException {
        SendCodeBean res = new SendCodeBean();
        try {
            res = gson.fromJson(json, SendCodeBean.class);
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
         * code : 2723
         * phone : 18993399470
         */

        private String code;
        private String phone;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
