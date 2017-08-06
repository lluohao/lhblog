package com.luohao.lhblog.biz.service.exception;

/**
 * Created by llhao on 2017/8/6.
 */
public class IllegalRequestException extends RuntimeException{
    public IllegalRequestException(String mesg){
        super(mesg);
    }

    public IllegalRequestException(){

    }
}
