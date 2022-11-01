package com.webservice.service.endpoint;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.service.entite.QuestionReqestService;
import com.webservice.service.entite.UserService;
import com.webservice.service.reqservice.QuestionGateWay;

import premium.service.gen.GetGateWayRequest;
import premium.service.gen.GetGateWayResponse;

@Endpoint
public class WebserviceEndpoint {
	
	private static final String NAMESPACE_URI = "http://premium/service/gen";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGateWayRequest")
	@ResponsePayload
	 public GetGateWayResponse getDataGateWay(@RequestPayload GetGateWayRequest request) {
		
		GetGateWayResponse response = new GetGateWayResponse();	   
		QuestionGateWay question = new QuestionGateWay();		 
		
		try {
			 response.setResultXML(question.BroadcastQuestion(userService,questionReqestService));
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	    return response;
	  }
}
