package com.KookBee.classservice.exception;

public class DayOffDateCheckException extends Exception{
    public DayOffDateCheckException() {
        super("신청하신 휴가가 두개의 커리큘럼에 속해있습니다. 다시 확인하시고 나누어 신청 부탁드립니다.");}
}
