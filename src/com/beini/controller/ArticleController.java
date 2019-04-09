package com.beini.controller;

import com.beini.bean.Article;
import com.beini.bean.UserInfo;
import com.beini.http.BaseResponseJson;
import com.beini.http.GetArticleRequest;
import com.beini.service.ArticleService;
import com.beini.util.BLog;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by beini on 2017/7/8.
 */
@Controller
public class ArticleController  extends BaseController{

    @Autowired
    private ArticleService userService;

    @RequestMapping("getArticleList")
//    @RequestBody GetArticleRequest getArticleRequest,
    public void getArticleList(HttpServletResponse response, PrintWriter out) {

        BLog.d(" ------------->getArticleList");
        List<Article> lists = userService.getArticles();
        BaseResponseJson responseJson = new BaseResponseJson();
        if (lists != null && lists.size() > 0) {
            responseJson.setReturnCode(0);
            responseJson.setReturnMessage(new Gson().toJson(lists));
        } else {
            responseJson.setReturnCode(1);
            responseJson.setReturnMessage("error");
        }
        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        BLog.d("    " + responseJson.toString());
        out.write(new Gson().toJson(responseJson));
    }

    @RequestMapping("test")
    public void testRequest(HttpServletResponse response, PrintWriter out) {
        BLog.d(" ------------->test");
        BaseResponseJson responseJson = new BaseResponseJson();
        responseJson.setReturnCode(0);
        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        out.write(new Gson().toJson(responseJson));
    }

    int i = 0;

    /**
     * timer
     * 开个定时器，定时接受APP发送过来的请求
     */
    @RequestMapping("timer")
    public void getInfoFromApp(HttpServletResponse response, PrintWriter out) {
        BLog.d(" ------------->i=" + i);
        i++;
//        BaseResponseJson responseJson = new BaseResponseJson();
//        responseJson.setReturnCode(0);
//        response.setContentType("text/htm;charset=utf-8");
//        response.setHeader("pragma", " no-cache");
//        response.setHeader("cache-control", "no-cache");
//        out.write(new Gson().toJson(responseJson));
    }


}
