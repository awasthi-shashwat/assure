package com.constructWeek3.assure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long member_id;
    private String name;
    private String relation_with_user;
    private Date DOB ;
    private String gender;
    private Boolean is_taking_medicines;
    private String city;
    private Boolean martial_status;
    private String email;
//    @Column(unique=true)
    private String mobile;
    private String occupation;
    private String height;
    private Float weight;

    @JsonIgnore
    @ManyToOne
    PolicyBookings policyBookings;

}
