package com.museum.springbootproject.Service.impl;

import com.museum.springbootproject.eception.ServiceException;
import com.museum.springbootproject.mapper.LoginMapper;
import com.museum.springbootproject.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//loginuser.getID()
@Service
public class LoginServiceimpl {
    @Autowired
    private LoginMapper loginMapper;
    public Login login(Login loginuser)
    {
        System.out.println(loginuser.getPassword());
        Login dbuser=loginMapper.selectByID(loginuser.getId());
        System.out.println(dbuser.getPassword());
        if(dbuser==null)
        {
            throw new ServiceException("账号不存在");
        }
//        System.out.println(dbuser.getPassword());
//        System.out.println(loginuser.getPassword());
        if(!loginuser.getPassword().equals(dbuser.getPassword()))
        {
            throw new ServiceException("用户名或密码错误");
        }
        return dbuser;

    }

    //注册用户的service
    public int  insert (String id,String password,String email)
    {
        int a= loginMapper.insert(id,password,email);
        return a;
    }

    //修改密码用的service
    public void returnword(String id,String password)
    {
//        Login dbuser=
        loginMapper.returnword(id,password);
//        if(dbuser==null)
//        {
//            throw new ServiceException("账号不存在");
//        }
//        System.out.println(dbuser.getPassword());
//        System.out.println(loginuser.getPassword());
//        return dbuser;
    }

}
