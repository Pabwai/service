package com.webservice.service.endpoint;

import java.io.IOException;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.service.reqservice.QuestionGateWay;

import premium.service.gen.GateWayRequest;
import premium.service.gen.GateWayResponse;

@Endpoint
public class WebserviceEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://premium/service/gen";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GateWayRequest")
	@ResponsePayload
	 public GateWayResponse getDataGateWay(@RequestPayload GateWayRequest request) {
		
		GateWayResponse response = new GateWayResponse();
	    response.setResultXML("SUCCESS");	 
		QuestionGateWay question = new QuestionGateWay();
		
		try {
			question.BroadcastQuestion(request);
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
