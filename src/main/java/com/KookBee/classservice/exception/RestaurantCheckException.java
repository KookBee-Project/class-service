package com.KookBee.classservice.exception;

public class RestaurantCheckException extends Exception{
    public RestaurantCheckException(){
        super("이미 등록된 지점입니다.");
    }
}
