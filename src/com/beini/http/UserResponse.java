package com.beini.http;

import com.beini.bean.UserInfo;

public class UserResponse extends BaseResponseJson {
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
