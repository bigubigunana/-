package com.museum.springbootproject.eception;

public class ServiceException  extends  RuntimeException{
    public ServiceException(String msg)
    {
        super(msg);
    }
}
