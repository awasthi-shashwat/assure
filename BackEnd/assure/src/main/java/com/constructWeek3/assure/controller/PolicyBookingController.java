package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.dto.PolicyBookingInputDTO;
import com.constructWeek3.assure.dto.PolicyBookingsGetListDTO;
import com.constructWeek3.assure.service.PolicyBookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PolicyBookingController {

    @Autowired
    private PolicyBookingsService policyBookingsService;

    //Get all policies booked by an user for the profile section
    @GetMapping("/bookings/{userId}")
    public ResponseEntity<List<PolicyBookingsGetListDTO>> getBookedPolicies(@PathVariable Long userId) {
        List<PolicyBookingsGetListDTO> policies = policyBookingsService.getBookedPolicies(userId);
        return new ResponseEntity<>(policies, HttpStatus.FOUND);
    }

    //An user of particular userId books a policy with all it's members
    @PostMapping("/booking/{userId}/{policyId}")
    public ResponseEntity<PolicyBookingInputDTO> bookPolicy(@PathVariable Long userId, @PathVariable Long policyId, @RequestBody PolicyBookingInputDTO policyBookingInputDTO) {
        PolicyBookingInputDTO bookingInputDTO = policyBookingsService.bookPolicy(userId, policyId, policyBookingInputDTO);
        return new ResponseEntity<>(bookingInputDTO, HttpStatus.CREATED);
    }
}
