package com.cuiwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restful")
public class RestfulController {

    /**
     * 根据ID进行查询
     */
    @GetMapping("/user/{id}")
    public String findById(@PathVariable Integer id){
        //调用service方法，完成id为2的这条记录的查询
        //问题findById方法中怎么才能获取到restful编程风格里面占位符的值
        return "findById:" + id;

    }

    /**
     * 新增的方法
     */

    @PostMapping("/user")
    public String post(){
        //新增
        return "post";
    }


    /**
     * 更新方法
     */

    @PutMapping("/user")
    public String put(){
        return "PUT";
    }


    /**
     * 删除方法
     */

    @DeleteMapping("/user/{id}")
    public String delete( @PathVariable Integer id){
        return "delete" + id;
    }
}
