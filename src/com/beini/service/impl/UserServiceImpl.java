package com.beini.service.impl;

import com.beini.bean.Article;
import com.beini.bean.UserInfo;
import com.beini.mapper.ArticleMapper;
import com.beini.mapper.UserInfoMapper;
import com.beini.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> login(String userName, String password) {
        return userInfoMapper.login(userName, password);
    }

    @Override
    public int register(UserInfo userInfo) {
        return userInfoMapper.register(userInfo);
    }


}
