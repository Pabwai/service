package com.webservice.service.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.service.service.Authentication;
import com.webservice.service.service.PublicKeyX509;
import com.webservice.service.service.QuestionGateWay;

import premium.service.gen.GetGateWayRequest;
import premium.service.gen.GetGateWayResponse;


@Endpoint
public class WebserviceEndpoint {
	
	GetGateWayResponse response;
	Authentication authenticationController ;
	QuestionGateWay questionGateWay;
	PublicKeyX509  x509 ;
	
	private static final String NAMESPACE_URI = "http://premium/service/gen";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGateWayRequest")
	@ResponsePayload
	 public GetGateWayResponse getDataGateWay(@RequestPayload GetGateWayRequest request) {		
		
		String getToken = authenticationController
				.AuthenticationToken(request.getUsername()
						, request.getPassword(), request.getCompanyCode());		
		
		String publlicKey = x509.GetPublicKey(request.getAnsCompany());
		
		
		String result = questionGateWay.BroadcastQuestion(publlicKey,getToken, request.getQusCompany()
				, request.getAnsCompany(), request.getServiceCode()
				, request.getServiceCondition(), request.getRequestDatetime());	
		
	    response.setResultXML(result);
		return response;
	  }
}
