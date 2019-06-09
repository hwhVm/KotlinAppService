package com.beini.controller;


import com.beini.bean.UserInfo;
import com.beini.bean.UserListInfo;
import com.beini.http.*;

import com.beini.service.UserService;
import com.beini.util.BLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = RequestUrl.USER_LOGIN, method = {RequestMethod.POST})
    public void login(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request, PrintWriter out) {

        BLog.d(" ------------->login" + userInfo.toString());
        UserResponse responseJson = new UserResponse();
        //todo 校验用户的信息是否合法

        //判断用户的登录信息是否完整
        String userName = userInfo.getUsername();
        String password = userInfo.getPassword();

        if (userName == null || userName.isEmpty()) {
            responseJson.setReturnCode(NetCode.CODE_FAILED);
            setResponse(responseJson, response, out);
            return;
        }

        if (password == null || password.isEmpty()) {
            responseJson.setReturnCode(NetCode.CODE_FAILED);
            setResponse(responseJson, response, out);
            return;
        }


//        判断用户是否登录
        HttpSession session = request.getSession();
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");

        if (userinfo != null && userinfo.getUsername().equals(userName)) {//用户已经登录
            BLog.d("  用户已经登录 ");
            responseJson.setReturnCode(NetCode.CODE_ALREADY_LOGINED);
            responseJson.setUserInfo(userinfo);
            setResponse(responseJson, response, out);
            return;
        }


        List<UserInfo> userInfoList = userService.login(userName, password);
        BLog.d("userInfoList.size()=" + userInfoList.size());

        if (userInfoList != null && userInfoList.size() > 0) {
            responseJson.setUserInfo(userInfoList.get(0));
            //24小时
            session.setMaxInactiveInterval(60 * 60 * 24);
            session.setAttribute("userinfo", userInfoList.get(0));


            responseJson.setReturnCode(NetCode.CODE_SUCCESS);

        } else {
            responseJson.setReturnCode(NetCode.CODE_FAILED);
        }

        setResponse(responseJson, response, out);

    }

    /**
     * 用户注册
     *
     * @param userInfo
     * @param response
     * @param out
     */
    @RequestMapping(value = RequestUrl.USER_REGISTER, method = {RequestMethod.POST})
    public void register(@RequestBody UserInfo userInfo, HttpServletResponse response, PrintWriter out) {
        BLog.d(" ------------->Register   " + userInfo.toString());
        BaseResponseJson baseResponseJson = new BaseResponseJson();
        //todo 判断当前操作用户是否是管理员

        //判断用户名和密码是否为空
        boolean isUserError = userInfo.getUsername() == null || userInfo.getUsername().isEmpty();
        boolean isPasswordError = userInfo.getPassword() == null || userInfo.getPassword().isEmpty();

        if (isUserError || isPasswordError) {//密码或者用户名为空
            baseResponseJson.setReturnCode(NetCode.CODE_FAILED);
            setResponse(baseResponseJson, response, out);
            return;

        }
        //TODO 判断用户的session


        //判断用户是否已经存在
        List<UserListInfo> userListInfoList = userService.findUserById(userInfo.getUsername());
        if (userListInfoList.size() > 0) {//用户已经存在
            baseResponseJson.setReturnCode(NetCode.CODE_ALREADY_EXIST);
            setResponse(baseResponseJson, response, out);
            return;

        }

        userInfo.setAdmin(0);

        int numRow = userService.register(userInfo);
        BLog.d("numRow=" + numRow);

        baseResponseJson.setReturnCode(NetCode.CODE_SUCCESS);
        setResponse(baseResponseJson, response, out);

    }

    /**
     * 用户列表
     *
     * @param response
     * @param request
     * @param out
     */
    @RequestMapping(value = RequestUrl.USER_USERLIST, method = {RequestMethod.POST})
    public void userList(HttpServletResponse response, HttpServletRequest request, PrintWriter out) {

        BLog.d(" ------------->userList");

        HttpSession session = request.getSession();

        UserListResponse baseResponseJson = new UserListResponse();

        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");

        if (userinfo == null) {
            baseResponseJson.setReturnCode(NetCode.CODE_SESSION_INVALID);
            setResponse(baseResponseJson, response, out);
            return;
        }
        List<UserListInfo> userListInfoList = userService.getUserList();

        //todo 判断是否是管理员
        baseResponseJson.setUserListInfoList(userListInfoList);
        baseResponseJson.setReturnCode(NetCode.CODE_SUCCESS);
        setResponse(baseResponseJson, response, out);

    }


    /**
     * 用户注册
     *
     * @param userInfo
     * @param response
     * @param out
     */
    @RequestMapping(value = RequestUrl.USER_DETELE, method = {RequestMethod.POST})
    public void deteleUser(@RequestBody UserInfo userInfo, HttpServletResponse response, PrintWriter out) {
        BLog.d(" ------------->deteleUser" + userInfo.toString());
        //todo 判断当前用户是否是管理员

        BaseResponseJson baseResponseJson = new BaseResponseJson();


        //判断用户名是否为空
        String userName = userInfo.getUsername();
        if (userName == null || userName.isEmpty()) {
            baseResponseJson.setReturnCode(NetCode.CODE_FAILED);
            setResponse(baseResponseJson, response, out);
            return;
        }

        int result = userService.deteleUser(userName);

        if (result == 1) {
            baseResponseJson.setReturnCode(NetCode.CODE_SUCCESS);
            setResponse(baseResponseJson, response, out);
        } else {
            baseResponseJson.setReturnCode(NetCode.CODE_FAILED);
            setResponse(baseResponseJson, response, out);
        }

    }
}
