package com.stte.smvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stte.smvc.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * create by BloodFly at 2020/7/13
 */
@Controller
@RequestMapping(value = "/json/")
public class HttpMessageConverterController {

    private static final Logger logger = LoggerFactory.getLogger(HttpMessageConverterController.class);

    //http://localhost:8080/json/jsonConverter
    @RequestMapping(value = "{path}", method = RequestMethod.GET)
    public String path(@PathVariable String path) {
        return path;
    }

    //http://localhost:8080/json/jsonConverter
    @RequestMapping(value = "testRequestBody-", method = RequestMethod.POST)
    public void testRequestBody(@RequestBody Book book, HttpServletResponse response) throws IOException {
        logger.info("request book {}", book);
        ObjectMapper mapper = new ObjectMapper();
        book.setAuthor("德马西亚");
        String jsonString = mapper.writeValueAsString(book);
        logger.info("{} to json:{}", book, jsonString);
        response.getWriter().println(jsonString); // 将字符串输出到客户端
    }

    //http://localhost:8080/json/jsonConverter
    @RequestMapping(value = "testRequestBody", method = RequestMethod.POST)
    public void testRequestBody2(@RequestBody Book book, HttpServletResponse response) throws IOException {
        logger.info("request book {}", book);
        book.setAuthor("德马西亚");
        String jsonString = JSONObject.toJSONString(book);
        logger.info("{} to json:{}", book, jsonString);
        response.getWriter().println(jsonString); // 将字符串输出到客户端
    }

    @RequestMapping(value = "testResponseBody")
    @ResponseBody
    public List<Book> testResponseBody() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(2, "spring mvc 企业应用实战", "肖文吉"));
        books.add(new Book(1, "轻量级J2EE企业应用实战", "李刚"));
        books.add(new Book(3, "Java Web开发技术大全", "李宁"));
        return books;
    }
}
