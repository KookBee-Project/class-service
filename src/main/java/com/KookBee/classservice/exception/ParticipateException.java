package com.KookBee.classservice.exception;

public class ParticipateException extends IllegalArgumentException{
    public ParticipateException() {
        super("이미 등록되었습니다.");
    }
}