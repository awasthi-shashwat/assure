package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.dto.PolicyDTO;
import com.constructWeek3.assure.dto.ageDTO;
import com.constructWeek3.assure.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/explore/policies")
    public ResponseEntity<List<PolicyDTO>> getPolicies(@RequestBody ageDTO ages) {
        List<PolicyDTO> policyDTOList = policyService.getPolicies(ages);
        return new ResponseEntity<>(policyDTOList, HttpStatus.FOUND);
    }

//    @GetMapping("policy/{id}/hospitals")
//    public ResponseEntity<List<>>

}
