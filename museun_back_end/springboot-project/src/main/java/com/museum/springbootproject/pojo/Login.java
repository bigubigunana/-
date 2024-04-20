package com.museum.springbootproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructo
@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Login {
    private String id;
    private String password;
    private String email;
//    private int status;
}
