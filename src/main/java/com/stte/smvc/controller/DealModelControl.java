package com.stte.smvc.controller;

import com.stte.smvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * Spring MVC 提供了以下几种途径输出模型数据：
 * ModelAndView: 处理方法返回值类型为 ModelAndView时, 方法体即可通过该对象添加模型数据
 * Map 及 Model: 入参为org.springframework.ui.Model、org.springframework.ui.ModelMap 或 java.uti.Map 时，处理方法返回时，Map 中的数据会自动添加到模型中。
 *
 * @SessionAttributes: 将模型中的某个属性暂存到HttpSession 中，以便多个请求之间可以共享这个属性
 * @ModelAttribute: 方法入参标注该注解后, 入参的对象就会放到数据模型中
 * <p>
 * <p>
 * 若希望在多个请求之间共用某个模型属性数据，则可以在控制器类上标注一个 @SessionAttributes, Spring MVC 将在模型中对应的属性暂存到 HttpSession 中。
 * @SessionAttributes 除了可以通过属性名指定需要放到会 话中的属性外，还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中
 * <p>
 * 如果在处理类定义处标注了@SessionAttributes(“xxx”)，则尝试从会话中获取该属性，并将其赋给该入参，然后再用请求消息填充该入参对象。
 * 如果在会话中找不到对应的属性，则抛出 HttpSessionRequiredException 异常
 * create by BloodFly at 2020/7/7
 */
@Controller
@SessionAttributes("user") // 选择性的将Model中的属性转存到HttpSession中
public class DealModelControl {


    /**
     * 该方法会往隐含模型中添加一个名为user的模型属性
     * 在方法定义上使用 @ModelAttribute 注解：Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法。
     *
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setAge(10);
        user.setUsername("小强");
        return user;
    }

    /**
     * Spring MVC 在内部使用了一个org.springframework.ui.Model 接口存储模型数据
     * 具体步骤:
     * Spring MVC 在调用方法前会创建一个隐含的模型对象作为模型数据的存储容器。
     * 如果方法的入参为 Map 或 Model类型，Spring MVC 会将隐含模型的引用传递给这些入参。
     * 在方法体内，开发者可以通过这个入参对象访问到模型中的所有数据，也可以向模型中添加新的属性数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/handleMap")
    public String handleMap(Map<String, Object> map) {
        map.put("time", new Date());
        User user = (User) map.get("user");
        user.setEmail("tt@188.com");
        return "success";

    }

    /**
     * 在方法的入参前使用@ModelAttribute 注解：可以从隐含对象中获取隐含的模型数据中获取对象，再将请求参数绑定到对象中，再传入入参将方法入参对象添加到模型中
     *
     * @param user
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect(@ModelAttribute("user") User user) {
        System.out.println("%%% redirect user: " + user);
        user.setAge(8);
        return "redirect:/redirect-to";

    }

    /**
     * ${sessionScope.user }
     *
     * @param map
     * @param sessionStatus
     * @return
     */
    @RequestMapping("redirect-to")
    public String redirectTo(Map<String, Object> map, SessionStatus sessionStatus) {
        User user = (User) map.get("user");
        System.out.println("%%% redirect-to user: " + user);
        user.setId(2000);
        System.out.println("sessionStatus: " + sessionStatus);
        return "success";
    }

}
