package com.museum.springbootproject.controller;

import cn.hutool.core.util.StrUtil;
import com.museum.springbootproject.Service.impl.LoginServiceimpl;
import com.museum.springbootproject.mapper.LoginMapper;
import com.museum.springbootproject.pojo.Login;
import com.museum.springbootproject.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RequestBody Login loginuser
@Slf4j
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private LoginServiceimpl loginService;
    @Autowired
    private LoginMapper loginMapper;
    //用户登录接口
    @PostMapping("/login")
    public Result loginconfirm(@RequestBody Login loginuser)
    {
        //这里是个判断id password，email是否为空
        if(StrUtil.isBlank(loginuser.getId())||StrUtil.isBlank(loginuser.getPassword()))
        {
            return Result.error("数据输入不合法");
        }
//        Login loginuser = new Login();
//        loginuser.setID("2021040209");
//        loginuser.setPassword("123456");
//        loginuser.setEmail("12345");
//        System.out.println((loginuser.getUsername()));
//        System.out.println((loginuser.getID()));
//        System.out.println((loginuser.getID()));
        loginuser=loginService.login(loginuser);
        return Result.success(loginuser);
    }

    //用户注册接口
    @GetMapping("/logins")
    public Result insert(@RequestParam(value="id",required = false)String id,@RequestParam(value="password",required = false)String password,@RequestParam(value="email",required = false)String email)
    {

        if(StrUtil.isBlank(id)||StrUtil.isBlank(password))
        {
            return Result.error("数据输入不合法");
        }
        Login b=loginMapper.selectByID(id);
        if(b!=null)
        {
            return Result.error("用户名已存在");
        }
        else {
            int a = loginService.insert(id, password,email);
            if (a == 0)
                return Result.error("用户名已存在");
            return Result.success("注册成功");
        }
    }


    //修改密码接口
    @PostMapping("/returnlogin")
    public Result returnword(@RequestParam(value="id",required = false)String id,@RequestParam(value="password",required = false)String password)
    {
        if(StrUtil.isBlank(id)||StrUtil.isBlank(password))
        {
            return Result.error("数据输入不合法");
        }
//        Login loginuser=
        loginService.returnword(id,password);
        return Result.success("更换密码成功");
    }
}
