package com.stte.smvc.controller;

import com.stte.smvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * create by BloodFly at 2020/7/16
 */
@Controller
@RequestMapping("/local/")
public class LocalController {

    private static final Logger logger = LoggerFactory.getLogger(LocalController.class);


    //http://localhost:8080/local/localLoginForm
    @RequestMapping("{path}")
    public String path(@PathVariable String path) {
        logger.info("access page: {}", path);
        return path;
    }


    //
    @RequestMapping("login")
    public String localLogin(User user, Model model, HttpServletRequest request) {
        if (user.getLoginname() != null && "fkit".equals(user.getLoginname())
                && user.getPassword() != null && "123456".equals(user.getPassword())) {
            // 从后台获取国际化消息
            RequestContext requestContext = new RequestContext(request);
            String username = requestContext.getMessage("username");
            user.setUsername(username);
            model.addAttribute("user", user);
            return "localSuccess";
        }
        return "error";
    }

    @RequestMapping(value = "session-language",method = RequestMethod.GET)
    public String changeLanguageSession(@RequestParam("request_local") String requestLocal,
                                 HttpServletRequest request) {
        logger.info("request_local:{}", requestLocal);
        if (requestLocal != null) {
            Locale locale = getLocale(requestLocal);
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        }
        return "localSessionForm";
    }
    @RequestMapping(value = "cookie-language",method = RequestMethod.GET)
    public String changeLanguageCookie(@RequestParam("request_local") String requestLocal,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        logger.info("request_local:{}", requestLocal);
        if (requestLocal != null) {
            Locale locale = getLocale(requestLocal);
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        }
        return "localCookieForm";
    }

    private Locale getLocale(String requestLocal) {
        Locale locale;
        if (requestLocal.equals("zh_CN")) { // 设置中文环境
            locale = new Locale("zh", "CN");
        } else if (requestLocal.equals("en_US")) {
            locale = new Locale("en", "US");
        } else {
            locale = LocaleContextHolder.getLocale();
        }
        return locale;
    }

}
