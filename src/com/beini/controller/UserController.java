package com.beini.controller;


import com.beini.bean.UserInfo;
import com.beini.http.BaseResponseJson;
import com.beini.mapper.UserInfoMapper;
import com.beini.util.BLog;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public void login(@RequestBody UserInfo userInfo, HttpServletResponse response, PrintWriter out) {

        BLog.d(" ------------->login" + userInfo.toString());

        BaseResponseJson responseJson = new BaseResponseJson();
        List<UserInfo> userInfoList = userInfoMapper.login(userInfo.getUsername(), userInfo.getPassword());
        if (userInfoList != null && userInfoList.size() > 0) {
            responseJson.setReturnCode(0);
        } else {
            responseJson.setReturnCode(1);
        }
        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        BLog.d("    " + responseJson.toString());
        out.write(new Gson().toJson(responseJson));
    }
}
