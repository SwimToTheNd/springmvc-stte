package com.stte.smvc.config;

import com.stte.smvc.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 自定义校验器，实现Spring的Validator接口
 * create by BloodFly at 2020/7/12
 */
@Component("userValidator")
public class UserValidator implements Validator {

    /**
     * 校验器支持的类型
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        //父类.class.isAssignableFrom(子类.class)
        //子类实例 instanceof 父类类型
        return User.class.isAssignableFrom(aClass);
    }

    /**
     * 对象目标类o进行校验，并将校验结果记录在errors当中
     *
     * @param o
     * @param errors
     */
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginname", null, "登陆名不能为空！");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "密码不能为空！");
        User user = (User) o;
        if (user.getLoginname().length() > 10) {
            // 使用Errors的rejectValue方法验证
            errors.rejectValue("loginname", null, "用户名不能超过10个字符！");
        }
        if (user.getPassword() != null && !"".equals(user.getPassword()) && user.getPassword().length() < 6) {
            errors.rejectValue("password", null, "密码不能小于6位");
        }
    }
}
