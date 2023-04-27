package com.KookBee.classservice.exception;

public class BootcampUserCheckException extends Exception{
    public BootcampUserCheckException(){
        super("이미 등록되어있는 강의입니다!");
    }
}
