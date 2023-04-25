package com.KookBee.classservice.exception;

public class DayOffUseDaysCheckException extends Exception{
    public DayOffUseDaysCheckException() {
        super("신청한 휴가일 수가 잔여휴가일 수 보다 많습니다.");}
}
