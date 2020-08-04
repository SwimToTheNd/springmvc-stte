package com.stte.smvc.controller;

import com.stte.smvc.config.UserValidator;
import com.stte.smvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * create by BloodFly at 2020/7/12
 */
@Controller
@RequestMapping("/validate/")
public class ValidateController {

    private static final Logger logger = LoggerFactory.getLogger(ValidateController.class);

    // 使用自定义的Validator校验器
    @Autowired
    private UserValidator userValidator;

    //http://localhost:8080/validate/loginForm2
    //http://localhost:8080/validate/registerForm3
    @RequestMapping(value = "{path}", method = RequestMethod.GET)
    public String loginForm(@PathVariable String path) {
        return path;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, Errors errors) {
        logger.info("{}", user);
        model.addAttribute("user", user);
        userValidator.validate(user, errors);
        // 验证不通过
        if (errors.hasErrors()) {
            return "loginForm2";
        }
        return "success";
    }

    //使用Hibernate Validator
    @RequestMapping(value = "jsr303", method = RequestMethod.POST)
    public String validateJSR303(@Valid User user, Errors errors, Model model) {
        logger.info("jsr303 user: " + user);
        if (errors.hasErrors()) {
            return "registerForm3";
        }
        return "welcome";
    }
}
