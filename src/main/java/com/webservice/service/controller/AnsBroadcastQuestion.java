package com.webservice.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.service.model.KnockForKnockRequestGateWay;

@RestController
@RequestMapping("users")
public class AnsBroadcastQuestion {
	
	@PostMapping
	public KnockForKnockRequestGateWay createUser(@RequestBody KnockForKnockRequestGateWay requestUserDetails) {
        

        return requestUserDetails;
    }

}
