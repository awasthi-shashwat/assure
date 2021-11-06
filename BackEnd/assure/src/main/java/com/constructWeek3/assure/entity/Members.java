package com.constructWeek3.assure.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long member_id;
    private String name;
    private String relation_with_user;
    private String DOB ;
    private String gender;
    private Boolean is_taking_medicines;
    private String city;
    private String martial_status;
    private String email;
    @Column(unique=true)
    private String mobile;
    private String occupation;
    private String height;
    private String weight;
    @ManyToOne
    PolicyBookings policyBookings;

}
