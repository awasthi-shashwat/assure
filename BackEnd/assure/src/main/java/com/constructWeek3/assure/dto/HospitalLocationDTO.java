package com.constructWeek3.assure.dto;

import com.constructWeek3.assure.entity.Hospitals;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
public class HospitalLocationDTO {

    private Set<Hospitals> hospitals = new HashSet<>();

}
