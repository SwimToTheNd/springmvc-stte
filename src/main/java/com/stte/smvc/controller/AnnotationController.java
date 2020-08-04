package com.stte.smvc.controller;

import com.stte.smvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * MVC 的 Handler 方法可以接受的ServletAPI 类型的参数：
 * HttpServletRequest HttpServletResponse HttpSession
 * java.security.Principal
 * Locale
 * InputStream OutputStream Reader Writer
 * <p>
 * spring MVC 类型：
 * Model
 * ModelMap
 * RedirectAttribute
 * Errors BindingResult
 * SessionStatus UriComponentBuilder
 *
 * @PathVariable @RequestParam @RequestHeader @RequestBody @RequestPart
 * <p>
 * <p>
 * 请求处理方法可以返回的类型：
 * ModelAndView Model Map<k,v> View String HttpEntity ResponseEntity Callable DeferredResult void
 * create by BloodFly at 2020/7/5
 */
@Controller
public class AnnotationController {

    /**
     * @return
     * @RequestMapping 注解为控制器指定可以处理哪些 URL 请求
     * DispatcherServlet 截获请求后，就通过控制器上的@RequestMapping提供的映射信息确定请求所对应的处理方法。
     * @RequestMapping 除了可以使用请求 URL 映射请求外,还可以使用请求方法、请求参数及请求头映射请求
     * @RequestMapping 的 value、method、params 及 heads  分别表示请求 URL、请求方法、请求参数及请求头的映射条件，他们之间是与的关系，联合使用多个条件可让请求映更加精确化。
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test() {
        System.out.println("hello world");
        return "success";
    }


    @RequestMapping("/delete/{id}")
    public void testPathVariable(@PathVariable("id") Integer id) {
        System.out.println(id);
    }

    /**
     * 在处理方法入参处使用 @RequestParam 用于将指定的请求参数赋值给方法中的形参
     * value：参数名
     * required：是否必须。默认为 true, 表示请求参数中必须包含对应的参数，若不存在，将抛出异常
     *
     * @param userName
     * @param age
     * @return
     */
    @RequestMapping("/param")
    public ModelAndView handle5(@RequestParam(value = "userName", required = false) String userName, @RequestParam("age") int age) {
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("age", age);
        return modelAndView;
    }

    /**
     * 请求头包含了若干个属性，服务器可据此获知客户端的信息，通过 @RequestHeader 即可将请求头中的属性值绑定到处理方法的入参中
     *
     * @param encoding
     * @param keepAlive
     * @return
     */
    @RequestMapping("/header")
    public String header(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Keep-Alive") long keepAlive) {
        System.out.println(encoding + "  keepAlive:" + keepAlive);
        return "success";
    }

    /**
     * @param sessionId
     * @return
     * @CookieValue 可以让处理方法入参绑定某个 Cookie 值
     */
    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "sessionId", required = false) String sessionId) {
        System.out.println("sessionId: " + sessionId);
        return "success";
    }

    /**
     * Spring MVC 会按 请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值。支持级联属性。
     * http://localhost:8080/user?id=123&username=小红&password=123456&email=xuy@163.com&age=44&address.province=shanghai&address.city=huangpu
     *
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public String user(User user) {
        System.out.println("user: " + user);
        return "success";
    }
}
