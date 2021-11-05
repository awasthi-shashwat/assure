package com.constructWeek3.assure.service;

import com.constructWeek3.assure.dto.PolicyDTO;
import com.constructWeek3.assure.dto.ageDTO;
import com.constructWeek3.assure.entity.Policy;
import com.constructWeek3.assure.modelmapper.ModelMapperClass;
import com.constructWeek3.assure.repository.PolicyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyService extends ModelMapper {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Float ageToPremium(Policy policy, Integer age) {
        if (age == 0) return 0.0F;
        if (age < 18) return policy.getPremiumUpto18();
        if (age < 45) return policy.getPremiumUpto45();
        if (age < 60) return policy.getPremiumUpto60();
        if (age >= 60) return policy.getPremiumBeyond60();
        return 0.0F;
    }

    public List<PolicyDTO> getPolicies(ageDTO ages) {

        List<Policy> policies = policyRepository.findAll();
        List<PolicyDTO> policyDTOList = modelMapper.map(policies, new TypeToken<List<PolicyDTO>>() {}.getType());

        for (int i = 0; i < policies.size(); i++) {

            Policy policy = policies.get(i);

            Float premium = ageToPremium(policy, ages.getAgeOfSelf());
            premium += ageToPremium(policy, ages.getAgeOfFather());
            premium += ageToPremium(policy, ages.getAgeOfMother());
            premium += ageToPremium(policy, ages.getAgeOfSon());
            premium += ageToPremium(policy, ages.getAgeOfDaughter());
            premium += ageToPremium(policy, ages.getAgeOfSpouse());

            policyDTOList.get(i).setPremium1(premium);
            policyDTOList.get(i).setPremium2(premium * 1.2F);
            policyDTOList.get(i).setPremium3(premium * 1.4F);

        }
        return policyDTOList;

    }
}
