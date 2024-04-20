package com.museum.springbootproject.mapper;

import com.museum.springbootproject.pojo.Login;
import org.apache.ibatis.annotations.*;

//http://localhost:8084/loginbigu
//ID=#{ID}
@Mapper
public interface LoginMapper {
    @Select("select * from museum_login where id= #{id} ")
    public Login selectByID(String id);

    @Insert("insert into museum_login(id,password,email) values (#{id},#{password},#{email})")
    public int  insert(@Param("id")String id, @Param("password")String password,@Param("email")String email);


    @Update("update museum_login set password=#{password} where id=#{id}")
    public void returnword(@Param("id")String id,@Param("password")String password);
}
