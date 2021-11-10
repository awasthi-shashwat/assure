package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.dto.ClaimDTO;
import com.constructWeek3.assure.dto.PolicyBookingInputDTO;
import com.constructWeek3.assure.entity.Claim;
import com.constructWeek3.assure.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController<T> {
    @Autowired
    ClaimService claimService;

    @PostMapping("/claim/{policyId}/{userId}/{memberId}")
    public ResponseEntity<Claim> claimInsurance(@PathVariable Long policyId, @PathVariable Long userId, @PathVariable Long memberId, @RequestBody ClaimDTO claimDTO) {
        ClaimDTO claimInsuranceDTO = claimService.claimInsurance(policyId, userId, memberId, claimDTO);
        return new ResponseEntity(claimInsuranceDTO, HttpStatus.CREATED);
    }
}
