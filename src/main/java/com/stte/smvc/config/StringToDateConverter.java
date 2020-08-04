package com.stte.smvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * create by BloodFly at 2020/7/10
 */
public class StringToDateConverter implements Converter<String, Date> {

    private static final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

    private String datePattern;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            logger.error("日期格式转换失败", e);
            e.printStackTrace();
        }
        return null;
    }
}
