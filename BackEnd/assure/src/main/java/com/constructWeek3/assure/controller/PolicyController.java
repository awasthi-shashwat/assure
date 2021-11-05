package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

}
