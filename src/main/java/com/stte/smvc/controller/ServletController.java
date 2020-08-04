package com.stte.smvc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 处理器基于Servlet 处理，使用SimpleServletHandlerAdapter适配器适配
 * create by BloodFly at 2020/7/6
 */
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello servlet");
        int i = 1 / 0;
    }
}
