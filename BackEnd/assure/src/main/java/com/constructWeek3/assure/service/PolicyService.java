package com.constructWeek3.assure.service;

import com.constructWeek3.assure.dto.PolicyDTO;
import com.constructWeek3.assure.dto.AgeDTO;
import com.constructWeek3.assure.entity.Policy;
import com.constructWeek3.assure.exception.InvalidAgeOfMemberException;
import com.constructWeek3.assure.repository.PolicyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<PolicyDTO> getPolicies(AgeDTO ages) {

//        Long user = ages.getUserId();

        Integer ageSelf = ages.getAgeOfSelf();
        Integer ageFather = ages.getAgeOfFather();
        Integer ageMother = ages.getAgeOfMother();
        Integer ageSpouse = ages.getAgeOfSpouse();
        Integer ageSon = ages.getAgeOfSon();
        Integer ageDaughter = ages.getAgeOfDaughter();

        if (ageFather < 0 || ageSelf < 0 || ageMother < 0 || ageDaughter < 0 || ageSpouse < 0 || ageSon < 0) throw new InvalidAgeOfMemberException("Invalid age specification. Age cannot be negative.");
        if (ageFather - ageSelf < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Father should be atleast 18 years elder than you.");
        if (ageMother - ageSelf < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Mother should be atleast 18 years elder than you.");
        if (ageSelf - ageSon < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Son should be atleast 18 years younger than you.");
        if (ageSelf - ageDaughter < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Daughter should be atleast 18 years younger than you.");
        if (ageSpouse - ageDaughter < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Daughter should be atleast 18 years younger than your spouse.");
        if (ageSpouse - ageSon < 18) throw new InvalidAgeOfMemberException("Invalid age specification. Your Son should be atleast 18 years younger than your spouse.");

        List<Policy> policies = policyRepository.findAll();
        List<PolicyDTO> policyDTOList = modelMapper.map(policies, new TypeToken<List<PolicyDTO>>() {}.getType());

        for (int i = 0; i < policies.size(); i++) {

            Policy policy = policies.get(i);

            Float premium = ageToPremium(policy, ageSelf);
            premium += ageToPremium(policy, ageFather);
            premium += ageToPremium(policy, ageMother);
            premium += ageToPremium(policy, ageSon);
            premium += ageToPremium(policy, ageDaughter);
            premium += ageToPremium(policy, ageSpouse);

            policyDTOList.get(i).setPremium1(premium);
            policyDTOList.get(i).setPremium2(premium * 1.2F);
            policyDTOList.get(i).setPremium3(premium * 1.4F);

        }
        return policyDTOList;

    }
}
