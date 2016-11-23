package com.huashitu.liveradio.bean;

import com.huashitu.liveradio.retrofit.HttpResult;

import java.util.List;

/**
 * 热门
 * Created by Administrator on 2016/11/14 0014.
 */

public class HotBean extends HttpResult{

    private int counts;
    private List<ListBean> list;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {

        private int pos;
        private int allnum;
        private int roomid;
        private int serverid;
        private String gps;
        private String flv;
        private int starlevel;
        private Object familyName;
        private int isSign;
        private String nation;
        private String nationFlag;
        private int useridx;
        private String userId;
        private int gender;
        private String myname;
        private String signatures;
        private String smallpic;
        private String bigpic;
        private int level;
        private int grade;
        private int curexp;

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getAllnum() {
            return allnum;
        }

        public void setAllnum(int allnum) {
            this.allnum = allnum;
        }

        public int getRoomid() {
            return roomid;
        }

        public void setRoomid(int roomid) {
            this.roomid = roomid;
        }

        public int getServerid() {
            return serverid;
        }

        public void setServerid(int serverid) {
            this.serverid = serverid;
        }

        public String getGps() {
            return gps;
        }

        public void setGps(String gps) {
            this.gps = gps;
        }

        public String getFlv() {
            return flv;
        }

        public void setFlv(String flv) {
            this.flv = flv;
        }

        public int getStarlevel() {
            return starlevel;
        }

        public void setStarlevel(int starlevel) {
            this.starlevel = starlevel;
        }

        public Object getFamilyName() {
            return familyName;
        }

        public void setFamilyName(Object familyName) {
            this.familyName = familyName;
        }

        public int getIsSign() {
            return isSign;
        }

        public void setIsSign(int isSign) {
            this.isSign = isSign;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getNationFlag() {
            return nationFlag;
        }

        public void setNationFlag(String nationFlag) {
            this.nationFlag = nationFlag;
        }

        public int getUseridx() {
            return useridx;
        }

        public void setUseridx(int useridx) {
            this.useridx = useridx;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getMyname() {
            return myname;
        }

        public void setMyname(String myname) {
            this.myname = myname;
        }

        public String getSignatures() {
            return signatures;
        }

        public void setSignatures(String signatures) {
            this.signatures = signatures;
        }

        public String getSmallpic() {
            return smallpic;
        }

        public void setSmallpic(String smallpic) {
            this.smallpic = smallpic;
        }

        public String getBigpic() {
            return bigpic;
        }

        public void setBigpic(String bigpic) {
            this.bigpic = bigpic;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getCurexp() {
            return curexp;
        }

        public void setCurexp(int curexp) {
            this.curexp = curexp;
        }
    }
}
