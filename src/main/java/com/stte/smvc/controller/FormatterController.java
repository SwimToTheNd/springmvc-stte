package com.stte.smvc.controller;

import com.stte.smvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试数据格式转换
 * FormattingConversionServiceFactoryBean
 * FormattingConversionService具有数据转换Converter和格式化Format的功能
 * create by BloodFly at 2020/7/11
 */
@Controller
@RequestMapping("format")
public class FormatterController {

    private static final Logger logger = LoggerFactory.getLogger(FormatterController.class);

    //http://localhost:8080/format/formatForm
    @RequestMapping(value = "/{path}")
    public String path(@PathVariable String path) {
        return path;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@ModelAttribute User user, Model model) {
        logger.info("user:{}", user);
        model.addAttribute("user", user);
        return "welcome";
    }
}
