package com.constructWeek3.assure.service;

import com.constructWeek3.assure.dto.MembersDTO;
import com.constructWeek3.assure.dto.PolicyBookingInputDTO;
import com.constructWeek3.assure.dto.PolicyBookingsGetListDTO;
import com.constructWeek3.assure.dto.ProfileMemberDTO;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.entity.Policy;
import com.constructWeek3.assure.entity.PolicyBookings;
import com.constructWeek3.assure.entity.User;
import com.constructWeek3.assure.exception.PolicyDoesNotExistException;
import com.constructWeek3.assure.exception.UserDoesNotExistException;
import com.constructWeek3.assure.repository.MembersRepository;
import com.constructWeek3.assure.repository.PolicyBookingsRepository;
import com.constructWeek3.assure.repository.PolicyRepository;
import com.constructWeek3.assure.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicyBookingsService {

    @Autowired
    private PolicyBookingsRepository policyBookingsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private ModelMapper modelMapper;


    public PolicyBookingInputDTO bookPolicy(Long userId, Long policyId, PolicyBookingInputDTO policyBookingInputDTO) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) throw new UserDoesNotExistException("No policy could be booked because the User does not exist!");

        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isEmpty()) throw new PolicyDoesNotExistException("The policy that you chose does not exist, so no policy could be booked.");

        PolicyBookings policyBooking = new PolicyBookings();
        policyBooking.setUser(user.get());
        policyBooking.setPolicy(policy.get());
        policyBooking.setPolicyName(policy.get().getPolicyName());
        policyBooking.setBookingDate(new Date());
        modelMapper.map(policyBookingInputDTO, policyBooking);

        Set<MembersDTO> membersDTOS = policyBookingInputDTO.getMembers();

        for (MembersDTO member :
                membersDTOS) {

            Members actualMember = new Members();
            modelMapper.map(member, actualMember);
            actualMember.setPolicyBookings(policyBooking);
            policyBooking.addMember(actualMember);
            membersRepository.save(actualMember);

        }

        policyBookingsRepository.save(policyBooking);
        return policyBookingInputDTO;
    }

    public List<PolicyBookingsGetListDTO> getBookedPolicies(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) throw new UserDoesNotExistException("No policy could be booked because the User does not exist!");

        List<PolicyBookings> policyBookings = user.get().getPolicyBookingsList();

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        List<PolicyBookingsGetListDTO> DTO = modelMapper.map(policyBookings, new TypeToken<List<PolicyBookingsGetListDTO>>() {}.getType());

        for (int i = 0; i < policyBookings.size(); i++) {

            List<ProfileMemberDTO> profileMemberDTO = modelMapper.map(policyBookings.get(i).getMembers(), new TypeToken<List<PolicyBookingsGetListDTO>>() {}.getType());
            DTO.get(i).setMemberDTOSet(profileMemberDTO);

        }

        return DTO;

    }
}
