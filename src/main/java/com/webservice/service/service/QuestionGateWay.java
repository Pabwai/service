package com.webservice.service.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.JsonObject;

public class QuestionGateWay {
	
	String url = "https://api.insure.co.th/QuestionService/BroadcastQuestion/";
	
	
	public String BroadcastQuestion(String token ,String qusCompany,String ansCompany,String serviceCondition,String requestDatetime){	
		
		JsonObject model = new JsonObject();
		model.addProperty("qusCompany", qusCompany);
		model.addProperty("ansCompany", ansCompany);	
		model.addProperty("serviceCondition", serviceCondition);		
		model.addProperty("requestDatetime", requestDatetime);	
		
		try {
			
	        HttpClient client = HttpClient.newHttpClient();	        
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("Content-Type", "application/json")
	        		.header("Authorization", "Bearer " + token) 
	                .uri(URI.create(url))
	                .POST(HttpRequest.BodyPublishers.ofString(model.toString()))
	                .build();       
		
	        HttpResponse<String> responent = client.send(request,HttpResponse.BodyHandlers.ofString());
	        
	    	return responent.body();    
	    
		} catch (IOException | InterruptedException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		

	}	

}
