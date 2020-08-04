package com.stte.smvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理器实现Controller接口
 * 基于 BeanNameUrlHandlerMapping  配置映谢
 * create by BloodFly at 2020/7/6
 */
public class SimpleControl implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("userView");
        modelAndView.addObject("name", "swim to the end");
        return modelAndView;
    }
}
