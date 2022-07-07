package com.cuiwei.controller;

import com.cuiwei.domain.QueryVo;
import com.cuiwei.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("username")  //向request域中存入key为username时，会同步到session域中
public class UserController {

    @RequestMapping("/quick")
    public String quick(Integer name){
        //业务逻辑
        System.out.println("SpringMVC入门成功");
        //视图跳转  逻辑视图名字
        return "success";
    }

    /**
     * 获取基本数据类型
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String username){
        System.out.println(id);
        System.out.println(username);
        return "success";
    }


    /**
     * 获取对象类型参数
     */
    @RequestMapping("/pojoParam")
    public String pojoParam(User user){
        System.out.println(user);
        return "success";
    }


    /**
     * 获取数组类型的请求参数
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    /**
     * 获取集合类型的请求参数
     */
    @RequestMapping("/queryParam")
    public String quertParam(QueryVo queryVo){

        System.out.println(queryVo);
        return "success";
    }


    /**
     * 获取日期类型参数
     */
    @RequestMapping("/coverParam")
    public String converterParam(Date birthday){
        System.out.println(birthday);
        return "success";
    }

    /**
     * 演示@RequestParam注解
     * RequestParam
     *  name 就是匹配页面传递参数的名称
     *  defaultValue  设置参数的默认值
     *  required  设置是否必须传递该参数，默认值为true 如果设置为默认值，值自动改为false
     */
   @RequestMapping("/findByPage")
    public String findByPage( @RequestParam(name="pageNo",defaultValue = "1",required = false)Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "success";
    }

    /**
     * 演示@RequestHeader注解的使用
     *
     */

    @RequestMapping("/RequestHeader")
    public String requestHead(@RequestHeader("cookie") String cookie){
        System.out.println(cookie);
        return "success";
    }

    /**
     * 演示@CookieValue注解的使用

     */
    @RequestMapping("/CookieValue")
    public String cookieValue(@CookieValue("JESSIONID") String jessionId){
        System.out.println(jessionId);
        return "success";
    }


    /**
     * 进行原始servletAPI进行的页面跳转
     */

    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{


        //直接返回数据
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("崔巍最帅");
        //借助request对象完成请求转发 一次请求
        //request.getRequestDispatcher("WEB-INF/pages/success.jsp").forward(request,response);

        //借助response对象完成重定向，两次请求

        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }


    /**
     * 显示forword关键字进行请求转发
     */

    @RequestMapping("/forward")
    public String forward(Model model){
        //还想在模型中设置一些值怎么做
        model.addAttribute("username","崔巍");
        /**
         * 使用forward请求转发，既可以转发到jsp,也可以转发到其他控制器方法
         */
        return "success";
    }


    /**
     * 演示@SessionAttributes
     */
    @RequestMapping("/returnString")
    public String returnString(){
        return "success";
    }

    /**
     * 演示Redirect 关键字进行重定向
 *
 */
@RequestMapping("/redirect")
public String redirect(Model model){
    model.addAttribute("username","cuiwei");
    return "redirect:/index.jsp";
}


/**
 * ModelandView的演示   方式一
 */

@RequestMapping("/ModelandView")
public ModelAndView ModelandView(Model model){
    /**
     * model  模型用来封装存放数据
     * view  用来展示数据
     */
    ModelAndView modelAndView = new ModelAndView();

    //设置要存放的数据
    modelAndView.addObject("username","崔巍要努力");

    //设置视图的名称，视图解析器解析modelandview拼接前缀和后缀
    modelAndView.setViewName("success");

    return modelAndView;

   }

    /**
     * ModelandView的演示   方式二
     * @param modelAndView
     * @return
     */
   @RequestMapping("/ModelandView2")
    public ModelAndView ModelandView2(ModelAndView modelAndView){
        /**
         * model  模型用来封装存放数据
         * view  用来展示数据
         */

        //设置要存放的数据
        modelAndView.addObject("username","崔巍要努力yayaya");

        //设置视图的名称，视图解析器解析modelandview拼接前缀和后缀
        modelAndView.setViewName("success");

        return modelAndView;

    }

    /**
     * ajax异步交互
     */
    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list){
        System.out.println(list);
        return list;

    }
}
