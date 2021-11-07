package com.constructWeek3.assure.service;

import com.constructWeek3.assure.dto.MembersDTO;
import com.constructWeek3.assure.dto.PolicyBookingInputDTO;
import com.constructWeek3.assure.dto.PolicyBookingsGetListDTO;
import com.constructWeek3.assure.dto.ProfileMemberDTO;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.entity.Policy;
import com.constructWeek3.assure.entity.PolicyBookings;
import com.constructWeek3.assure.entity.User;
import com.constructWeek3.assure.exception.*;
import com.constructWeek3.assure.repository.MembersRepository;
import com.constructWeek3.assure.repository.PolicyBookingsRepository;
import com.constructWeek3.assure.repository.PolicyRepository;
import com.constructWeek3.assure.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String isValidEmail(String email) {
        int at = email.indexOf('@');
        if (at < 5) return "Your email has less than 6 characters before @ sign";
        if (at != email.lastIndexOf('@')) return "Your email has 2 @ signs.";
        if(email.lastIndexOf('.') < at) return "Invalid domain name.";
        if(Character.isDigit(email.charAt(0))) return "A valid email cannot start with a digit.";
        return "";
    }

    public Boolean isValidMobile(String number) {

        Pattern mobNoPattern = Pattern.compile("[5-9][0-9]{9}");

        Matcher mobNoMatcher = mobNoPattern.matcher(number);
        return (mobNoMatcher.find() && mobNoMatcher.group().equals(number));

    }

    public Boolean isValidGender(String gender) {

        gender.toLowerCase();
        return gender.equals("male") || gender.equals("female") || gender.equals("transgender");

    }

    public PolicyBookingInputDTO bookPolicy(Long userId, Long policyId, PolicyBookingInputDTO policyBookingInputDTO) {

        //Checking for any inconsistency in the input data

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) throw new UserDoesNotExistException("No policy could be booked because the User does not exist!");

        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isEmpty()) throw new PolicyDoesNotExistException("The policy that you chose does not exist, so no policy could be booked.");

        Set<MembersDTO> membersDTOS = policyBookingInputDTO.getMembers();

        for (MembersDTO member :
                membersDTOS) {

            if (!isValidMobile(member.getMobile())) throw new InvalidMobileNumberException("Enter a correct 10 digit mobile number without starting with appending country code or 0.");
            if (!isValidGender(member.getGender())) throw new InvalidGenderException("Gender can be either male, female or transgender. (Case-Insensitive)");
            String message = isValidEmail(member.getEmail());
            if (message.length() > 0) throw new InvalidEmailException(message);

        }

        //Processing request after validation of consistency of input data.

        PolicyBookings policyBooking = new PolicyBookings();
        policyBooking.setUser(user.get());
        policyBooking.setPolicy(policy.get());
        policyBooking.setPolicyName(policy.get().getPolicyName());
        policyBooking.setBookingDate(new Date());
        modelMapper.map(policyBookingInputDTO, policyBooking);

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
