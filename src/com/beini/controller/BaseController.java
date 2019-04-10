package com.beini.controller;

import com.beini.http.BaseResponseJson;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BaseController {
    public void setResponse(BaseResponseJson responseJson, HttpServletResponse response, PrintWriter out) {


        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");

        out.write(new Gson().toJson(responseJson));
    }

}
