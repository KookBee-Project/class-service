package com.KookBee.classservice.exception;

public class DayOffNoneCurriculumException extends Exception{
    public DayOffNoneCurriculumException(){
        super("선택하신 날짜는 존재하지 않는 커리큘럼입니다.");
    }
}
