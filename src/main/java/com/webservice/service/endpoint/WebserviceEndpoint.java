package com.webservice.service.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

import com.webservice.service.reqservice.QuestionGateWay;

import premium.service.gen.GateWayRequest;
import premium.service.gen.GateWayResponse;

@Endpoint
public class WebserviceEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://premium/service/gen";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GateWayRequest")
	@ResponsePayload
	 public GateWayResponse getDataGateWay(@RequestPayload GateWayRequest request) {
		
		Map<String,Object> map = new HashMap<String,Object>();    
		
		map.put("GateWayRequest", request);
		
		QuestionGateWay question = new QuestionGateWay();
		question.Question(map);
		
		GateWayResponse response = new GateWayResponse();
	    response.setResultXML("SUCCESS");	 
	    return response;
	  }
}
