package com.webservice.service.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.JsonObject;

public class PublicKeyX509 {
	
	private static final String PublicUri  = "https://httpbin.org/anything";	
	
	@ResponseStatus
	public String GetPublicKey(String companyCode){			
		
		JsonObject model = new JsonObject();
		
		model.addProperty("companyCode", companyCode);					
		
		try {
			
	        HttpClient client = HttpClient.newHttpClient();	        
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("Content-Type", "application/json")
	                .uri(URI.create(PublicUri))
	                .POST(HttpRequest.BodyPublishers.ofString(model.toString()))
	                .build();       
		
	        HttpResponse<String> responent = client.send(request,HttpResponse.BodyHandlers.ofString());
	        
	    	return responent.body();    
	    
		} catch (IOException | InterruptedException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}  
	
	}

}