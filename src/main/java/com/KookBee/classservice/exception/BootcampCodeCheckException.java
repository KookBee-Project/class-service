package com.KookBee.classservice.exception;

public class BootcampCodeCheckException extends Exception{
    public BootcampCodeCheckException() {
        super("잘못된 코드를 입력하셨습니다");
    }
}
