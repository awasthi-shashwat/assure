package com.constructWeek3.assure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Entity
public class PolicyBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Date date;
    private Float coverAmount;
    private Float premium;
    private Integer coverTenure;

//    @OneToMany
//    private HashSet<Members> members = new HashSet<Members>();

    @JsonIgnore

    @ManyToOne
    private Policy policy;

    @ManyToOne
    private User user;



}
