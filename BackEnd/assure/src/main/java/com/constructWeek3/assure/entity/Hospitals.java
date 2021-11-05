package com.constructWeek3.assure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospitals {

    @Id
    private Long hospitalId;
    private String name;

}
