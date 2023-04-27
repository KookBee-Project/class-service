package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.client.User;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentListResponse {
    private Long id;

    private String userName;
    public StudentListResponse(StudentBootcamp studentBootcamp, User user){
        this.id = studentBootcamp.getStudentId();
        this.userName = user.getUserName();
    }
}
