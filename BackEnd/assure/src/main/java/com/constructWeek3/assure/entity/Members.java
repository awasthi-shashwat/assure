package com.constructWeek3.assure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
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
    @Column(unique=true)
    private String mobile;
    private String occupation;
    private String height;
    private Float weight;

    @OneToMany
    @JoinColumn(name="member_member_id")
    private List<Claim> claim = new ArrayList<>();

    @JsonIgnore
    @ManyToOne()
    PolicyBookings policyBookings;

}
