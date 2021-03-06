package com.beini.service;

import com.beini.bean.UserInfo;
import com.beini.bean.UserListInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> login(String userName, String password);

    int register(UserInfo userInfo);

    List<UserListInfo> getUserList();

    List<UserListInfo> findUserById(String userName);


    int deteleUser(String userName);
}
