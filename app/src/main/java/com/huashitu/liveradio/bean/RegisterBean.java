package com.huashitu.liveradio.bean;

import com.google.gson.JsonSyntaxException;
import com.midian.base.app.AppException;
import com.midian.base.bean.NetResult;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class RegisterBean extends NetResult {

    /**
     * content : {"income":0,"userFrom":1,"level":1,"tokenTime":"2016-11-15 17:55:43","isAdmin":2,"token":"309296a27038f29c5dfa89f2ea4018d7","certification":2,"deleteFlag":1,"beAttentioned":0,"password":"fe703d258c7ef5f50b71e06565a65aa07194907f","contribution":0,"balance":0,"phone":"18993399470","createTime":"2016-11-15 17:55:43","identity":1,"attention":0,"id":97,"account":"18993399470","live":0}
     */

    private Content content;

    public static RegisterBean parse(String json) throws AppException {
        RegisterBean res = new RegisterBean();
        try {
            res = gson.fromJson(json, RegisterBean.class);
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
         * income : 0
         * userFrom : 1
         * level : 1
         * tokenTime : 2016-11-15 17:55:43
         * isAdmin : 2
         * token : 309296a27038f29c5dfa89f2ea4018d7
         * certification : 2
         * deleteFlag : 1
         * beAttentioned : 0
         * password : fe703d258c7ef5f50b71e06565a65aa07194907f
         * contribution : 0
         * balance : 0
         * phone : 18993399470
         * createTime : 2016-11-15 17:55:43
         * identity : 1
         * attention : 0
         * id : 97
         * account : 18993399470
         * live : 0
         */

        private String income;
        private String userFrom;
        private String level;
        private String tokenTime;
        private String isAdmin;
        private String token;
        private String certification;
        private String deleteFlag;
        private String beAttentioned;
        private String password;
        private String contribution;
        private String balance;
        private String phone;
        private String createTime;
        private String identity;
        private String attention;
        private String id;
        private String account;
        private String live;

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }

        public String getUserFrom() {
            return userFrom;
        }

        public void setUserFrom(String userFrom) {
            this.userFrom = userFrom;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getTokenTime() {
            return tokenTime;
        }

        public void setTokenTime(String tokenTime) {
            this.tokenTime = tokenTime;
        }

        public String getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(String isAdmin) {
            this.isAdmin = isAdmin;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getCertification() {
            return certification;
        }

        public void setCertification(String certification) {
            this.certification = certification;
        }

        public String getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public String getBeAttentioned() {
            return beAttentioned;
        }

        public void setBeAttentioned(String beAttentioned) {
            this.beAttentioned = beAttentioned;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getContribution() {
            return contribution;
        }

        public void setContribution(String contribution) {
            this.contribution = contribution;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getAttention() {
            return attention;
        }

        public void setAttention(String attention) {
            this.attention = attention;
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

        public String getLive() {
            return live;
        }

        public void setLive(String live) {
            this.live = live;
        }
    }
}
