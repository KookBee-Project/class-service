package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductRequest {
    public Long manager_id;
    public Long student_id;
    public Date product_rental_start_date;
    public Date product_rental_end_date;
    public String product_name;
    public String product_code;
    public EProductType product_type;
    public EProductStatus product_status;
    public Integer product_count;
    public ProductRequest(Student student){
        this.student_id = student.getStudentId();
    }
}
