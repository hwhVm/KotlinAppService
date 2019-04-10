package com.beini.service;

import com.beini.bean.UserInfo;
import com.beini.http.UserResponse;

import java.util.List;

public interface UserService {
     List<UserInfo> login(String userName, String password);

    int register(UserInfo userInfo);
}
