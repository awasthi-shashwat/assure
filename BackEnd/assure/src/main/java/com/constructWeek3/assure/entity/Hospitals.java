package com.constructWeek3.assure.entity;

import javax.persistence.*;

@Entity
public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String name;

    @ManyToOne
    private Location location;
}
