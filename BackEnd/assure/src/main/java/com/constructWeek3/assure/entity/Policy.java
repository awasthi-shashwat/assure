package com.constructWeek3.assure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policyName;
    private String roomRentLimit;
    private Float claimBonus;
    private String pedWaitingPeriod; //waiting period of pre-existing-disease cover
    private Float copayPercent;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Hospitals> hospitals = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Location> locations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<PolicyBookings> policyBookings = new HashSet<>();


}
