package com.it.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConvert implements Converter<String,Date>{
    @Override
    public Date convert(String s) {
        //判断数据为空  str == null || "".equals(str)
        if (StringUtils.isEmpty(s)){
            throw new RuntimeException("数据源为空");
        }
        try {
            //转换日期类型
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch (ParseException e) {
            throw new RuntimeException ("支持日期类型为yyyy-MM-dd的转换！");
        }
    }
}
