package com.beini.timer;


import com.beini.bean.PollingBean;
import com.beini.controller.BaseController;
import com.beini.util.BLog;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


@Controller
public class TimerController extends BaseController {


    @RequestMapping(value = "polling", method = {RequestMethod.POST})
    public void login(@RequestBody PollingBean pollingBean, HttpServletResponse response, HttpServletRequest request, PrintWriter out) {
        BLog.d("  polling ");
        //如果1分钟内没有接收到请求就推送给客户端，进行唤醒操作

        HttpSession session = request.getSession();


        String id = (String) session.getAttribute("id");
        if (id == null) {
            session.setAttribute("id", pollingBean.getTime());
        }


    }


    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void taskCycle() {



    }


}