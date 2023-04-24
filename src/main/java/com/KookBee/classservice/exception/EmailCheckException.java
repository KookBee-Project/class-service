package com.KookBee.classservice.exception;

public class EmailCheckException extends Exception{
    public EmailCheckException(){
        super("중복된 이메일입니다.");
    }
}
