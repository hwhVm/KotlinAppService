package com.beini.controller;


import com.beini.bean.UserInfo;
import com.beini.http.BaseResponseJson;
import com.beini.mapper.UserInfoMapper;
import com.beini.service.UserService;
import com.beini.service.impl.UserServiceImpl;
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
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    /**
     * 登录
     *
     * @param userInfo
     * @param response
     * @param out
     */
    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public void login(@RequestBody UserInfo userInfo, HttpServletResponse response, PrintWriter out) {

        BLog.d(" ------------->login" + userInfo.toString());

        BaseResponseJson responseJson = new BaseResponseJson();
        List<UserInfo> userInfoList = userService.login(userInfo.getUsername(), userInfo.getPassword());
        BLog.d("userInfoList.size()=" + userInfoList.size());
        if (userInfoList != null && userInfoList.size() > 0) {
            responseJson.setReturnCode(0);
        } else {
            responseJson.setReturnCode(1);
        }

        setResponse(responseJson, response, out);

    }


    @RequestMapping(value = "register", method = {RequestMethod.POST})
    public void register(@RequestBody UserInfo userInfo, HttpServletResponse response, PrintWriter out) {
        BLog.d(" ------------->Register" + userInfo.toString());

        int numRow = userService.register(userInfo);
        BLog.d("numRow=" + numRow);
        BaseResponseJson baseResponseJson = new BaseResponseJson();
        baseResponseJson.setReturnCode(0);
        setResponse(baseResponseJson, response, out);

    }


}
