package com.webservice.service.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.JsonObject;
import com.webservice.service.service.Authentication;
import com.webservice.service.service.GetPublicKey;
import com.webservice.service.service.QuestionGateWay;

import premium.service.gen.GetGateWayRequest;
import premium.service.gen.GetGateWayResponse;


@Endpoint
public class WebserviceEndpoint {
	
	GetGateWayResponse response;
	QuestionGateWay questionGateWay;
	GetPublicKey  getPublicKey ;
	
	private static final String NAMESPACE_URI = "http://premium/service/gen";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGateWayRequest")
	@ResponsePayload
	 public GetGateWayResponse getDataGateWay(@RequestPayload GetGateWayRequest request) {		
		Authentication authenticationController = new Authentication();
		String getToken = authenticationController.AuthenticationToken(request.getUsername(), request.getPassword(), request.getCompanyCode());		
		/*
		 * String publicKey = getPublicKey.PublicKey(request.getAnsCompany());
		 * 
		 * 
		 * String result = questionGateWay.BroadcastQuestion(getToken,
		 * request.getQusCompany() , request.getAnsCompany(),
		 * request.getServiceCondition(), request.getRequestDatetime());
		 */
		System.out.println(getToken);
	    response.setResultXML(getToken);
		return response;
	  }
}
