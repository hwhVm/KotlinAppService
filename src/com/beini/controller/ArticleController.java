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
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService userService;

    @RequestMapping("getArticleList")
//  @RequestBody GetArticleRequest getArticleRequest,
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
        setResponse(responseJson, response, out);
    }


}
