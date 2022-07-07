package com.cuiwei.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /**
    Exception e 就是我们抛出的异常对象
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //具体的异常处理，产生异常后，跳转到最终的页面

        ModelAndView modelAndView = new ModelAndView();
        //获取异常内容
        modelAndView.addObject("error",e.getMessage());
        //实现跳转
        modelAndView.setViewName("error");

        return modelAndView;

    }
}
