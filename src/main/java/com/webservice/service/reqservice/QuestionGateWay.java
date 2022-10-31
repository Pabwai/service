package com.webservice.service.reqservice;

import java.util.Map;

import premium.service.gen.GateWayRequest;

public class QuestionGateWay {
	
	public String Question(Map<String,Object> map ) {	
		
		GateWayRequest gateWayRequest = null  ;   
		
		for(Map.Entry<String, Object> entry:map.entrySet()){
			gateWayRequest = (GateWayRequest) entry.getValue();
	         
	    } 	
		
		System.out.println(gateWayRequest.toString()); 
;		
		return null;
		
	}

}
