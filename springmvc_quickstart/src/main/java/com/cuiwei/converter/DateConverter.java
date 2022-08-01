package com.cuiwei.converter;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateConverter implements Converter<String , Date> {
    //这里的s  就是表单传递和过来的请求参数
    public Date convert(String s) {
        //将日期字符串转换为日期对象返回
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
             date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
