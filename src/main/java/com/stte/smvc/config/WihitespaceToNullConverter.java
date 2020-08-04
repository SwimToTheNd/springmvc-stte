package com.stte.smvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * 不能使用Convertor将参数空字符串转换成null。
 * create by BloodFly at 2020/7/10
 */
public class WihitespaceToNullConverter implements Converter<String, Object> {

    private static final Logger logger = LoggerFactory.getLogger(WihitespaceToNullConverter.class);

    @Override
    public Object convert(String s) {
        if ("".equals(s)) {
            return null;
        }
        return s;
    }
}
