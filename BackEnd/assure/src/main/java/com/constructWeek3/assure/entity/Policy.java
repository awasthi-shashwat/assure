package com.constructWeek3.assure.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String name;
    private String room_rent_limit;
    private Float claim_bonus;
    private String ped_waiting_period; //waiting period of pre-existing-disease cover
    private Float copay_percent;
    private Boolean isCriticalIllnessCovered;
    private Boolean isMaternityCovered;
    private Boolean isRestorationBenefitsCovered;
    private Float premiumUpto18;
    private Float premiumUpto45;
    private Float premiumUpto60;
    private Float premiumBeyond60;
    private Float coverAmount1;
    private Float coverAmount2;
    private Float coverAmount3;
    private Integer tenure1;
    private Integer tenure2;
    private Integer tenure3;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Hospitals> hospitals = new HashSet<>();

//    @OneToMany
//    private Set<Locations> locations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PolicyBookings> policyBookings = new HashSet<>();


}
