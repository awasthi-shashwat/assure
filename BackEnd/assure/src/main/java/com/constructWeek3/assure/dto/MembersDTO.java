package com.constructWeek3.assure.dto;

import com.constructWeek3.assure.entity.PolicyBookings;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class MembersDTO {

    private Long member_id;
    private String name;
    private String relation_with_user;
    private String DOB ;
    private String gender;
    private Boolean is_taking_medicines;
    private String city;
    private String martial_status;
    private String email;
    private String mobile;
    private String occupation;
    private String height;
    private String weight;
    PolicyBookings policyBookings;
}
