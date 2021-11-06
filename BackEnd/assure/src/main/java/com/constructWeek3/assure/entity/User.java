package com.constructWeek3.assure.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String userName;
    private String userEmail;
    private String userMobile;
    private String userPass;

    @OneToMany
    private List<Policy> policyList = new ArrayList<>();

    public void setPolicy(Policy policy){
        this.policyList.add(policy);
    }

    public void removePolicy(Policy policy){
        this.policyList.remove(policy);
    }

//    @OneToMany
//    private List<Claims> claimsList = new ArrayList<>();
//
//    public void setClaims(Policy policy){
//        this.policyList.add(policy);
//    }
//
//    public void removeClaims(Policy policy){
//        this.policyList.remove(policy);
//    }
}
