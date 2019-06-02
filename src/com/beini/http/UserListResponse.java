package com.beini.http;

import com.beini.bean.UserListInfo;

import java.util.List;

public class UserListResponse extends BaseResponseJson {

    private List<UserListInfo> userListInfoList;

    public List<UserListInfo> getUserListInfoList() {
        return userListInfoList;
    }

    public void setUserListInfoList(List<UserListInfo> userListInfoList) {
        this.userListInfoList = userListInfoList;
    }
}
