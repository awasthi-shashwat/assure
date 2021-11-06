package com.constructWeek3.assure.dto;

import com.constructWeek3.assure.entity.PolicyBookings;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class MembersDTO {


    private String name;
    private String relation_with_user;
    private Date DOB ;
    private String gender;
    private Boolean is_taking_medicines;
    private String city;
    private String martial_status;
    private String email;
    private String mobile;
    private String occupation;
    private String height;
    private String weight;
//    PolicyBookings policyBookings;
}
