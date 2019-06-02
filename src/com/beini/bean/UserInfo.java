package com.beini.bean;


public class UserInfo extends BaseBean {


    private long mId;

    private long id;

    private String userId;

    private String imei;

    private String username;

    private int isAdmin;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String password;


    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getMId() {
        return this.mId;
    }

    public void setMId(long mId) {
        this.mId = mId;
    }

    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "mId=" + mId +
                ", id=" + id +
                ", userId='" + userId + '\'' +
                ", imei='" + imei + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
