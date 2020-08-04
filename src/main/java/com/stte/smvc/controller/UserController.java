package com.stte.smvc.controller;

import com.stte.smvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * create by BloodFly at 2020/7/8
 */
@Controller
@RequestMapping("/user/")
@SessionAttributes("user")  // 将Model中属性为user的值放到HttpSession中
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static List<User> users = new ArrayList<>();

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm() {
        return "registerForm";
    }

    /**
     * 用户注册，注册成功后跳转到时登陆页面
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("loginname") String loginname) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLoginname(loginname);
        users.add(user);
        logger.info("user:{} register success", user);
        return "loginForm";
    }


    /**
     * 登陆成功跳转到welcome页面，失败时跳转到登陆页面loginForm
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String password,
                        Model model) {
        logger.info("登陆名：{}，密码：{}", loginname, password);
        for (User user : users) {
            if (user.getLoginname().equals(loginname) && user.getPassword().equals(password)) {
                // 登陆成功,将user对象添加到Model中
                model.addAttribute("user", user);
                return "welcome";
            }
        }
        return "loginForm";
    }

    /**
     * http://localhost:8080/user/registerForm
     * http://localhost:8080/user/registerForm2
     * 动态跳转页面
     * @param formName
     * @return
     */
    @RequestMapping(value = "{formName}", method = RequestMethod.GET)
    public String path(@PathVariable("formName") String formName) {
        return formName;
    }


    @RequestMapping(value = "register2", method = RequestMethod.POST)
    public String register2(User user, Model model) {
        logger.info("user:{}", user);
        model.addAttribute("user", user);
        return "welcome";
    }
}
