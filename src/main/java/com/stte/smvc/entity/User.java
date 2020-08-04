package com.stte.smvc.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class User {

    private Integer id;
    @NotNull(message = "登陆名不能为空！")
    private String loginname;

    private String username;

    @NotNull(message = "密码不能为空！")
    @Length(min = 6, max = 8, message = "密码长度必须在6位至8位之间")
    private String password;

    // 日期类型 不使用@DateTimeFormat需要使用自定义的Converter，来将String类型转换为Date类型
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "生日必须是一个过去的日期")
    private Date birthday;

    @Email(message = "必须是合法的邮件地址")
    private String email;

    @Range(min = 15, max = 60, message = "年龄必须在15岁到60岁之间")
    private int age;

    // 正常数字 千分位
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###")
    private int total;

    // 百分数格式
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double discount;

    //货币格式
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double money;

    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "无效的电话号码")
    private String phone;

    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", total=" + total +
                ", discount=" + discount +
                ", money=" + money +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
