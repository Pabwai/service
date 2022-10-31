package com.webservice.service.reqservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import com.google.gson.Gson;

import premium.service.gen.GateWayRequest;


public class QuestionGateWay {
	
	private static final String TokenUri  = "https://httpbin.org/anything";
	
	
	
	public String BroadcastQuestion(GateWayRequest request) throws IOException, InterruptedException {	
		 
		
	     return Authentication(request);
		
	}
	
	@ResponseStatus
	public String Authentication(GateWayRequest data){	
		
		HashMap<String, String> userlogin = new HashMap<String, String>();
		HttpResponse<String> response = null;
		Gson gson = new Gson();
		userlogin.put("username", data.getUsername());
		userlogin.put("password", data.getPassword());
		userlogin.put("companyCode", data.getCompanyCode());				

		
		try {
			
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("Content-Type", "application/json")
	                .uri(URI.create(TokenUri))
	                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(userlogin)))
	                .build();        
		
			  response = client.send(request,HttpResponse.BodyHandlers.ofString());
			  
		} catch (IOException | InterruptedException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}       
	 
	    return response.body();
		
	}
	
	
	
	
	
	
	

}
