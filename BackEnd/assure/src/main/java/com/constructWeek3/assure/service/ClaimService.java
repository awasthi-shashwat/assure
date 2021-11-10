package com.constructWeek3.assure.service;

import com.constructWeek3.assure.dto.ClaimDTO;
import com.constructWeek3.assure.dto.PolicyBookingInputDTO;
import com.constructWeek3.assure.entity.Claim;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {
    @Autowired
    ClaimService claimService;

    @Autowired
    ModelMapper modelMapper;



    public ClaimDTO claimInsurance(Long policyId, Long userId, Long memberId, ClaimDTO claimDTO) {

        modelMapper.map(claimDTO, Claim.class);
        return claimDTO;
    }
}
