package com.stte.smvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * create by BloodFly at 2020/7/18
 */
@Controller
@RequestMapping("/upload/")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);


    @RequestMapping(value = "{path}", method = RequestMethod.GET)
    public String path(@PathVariable String path) {
        return path;
    }

    @RequestMapping(value = "file", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("description") String description,
                             @RequestParam("file") MultipartFile multipartFile,
                             HttpServletRequest request) throws IOException {
        logger.info("description:{}", description);
        if (!multipartFile.isEmpty()) {
            // 上传保存文件的路径
            String realPath = request.getServletContext().getRealPath("/image/");// 将相对路径转换为绝对路径
            // 获取文件的原名
            String originalFilename = multipartFile.getOriginalFilename();
            logger.info("realapth:{}, originalFilename:{}, filename:{}, size:{}, contentType:{}", realPath, originalFilename, multipartFile.getName(), multipartFile.getSize(), multipartFile.getContentType());
            File file = new File(realPath, originalFilename);
            // 判断路径是否存在，不存在则创建一个
            logger.info("parentFile:{}", file.getParentFile().getName());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 将上传文件保存到目标文件当中
            multipartFile.transferTo(file);
            return "success";
        }
        return "error";
    }
}
