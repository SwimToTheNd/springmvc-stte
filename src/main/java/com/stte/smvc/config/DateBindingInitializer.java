package com.stte.smvc.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * 使用全局WebBindingInitializer注册全局自定义编辑器转换数据
 * create by BloodFly at 2020/7/11
 */
public class DateBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
    }
}
