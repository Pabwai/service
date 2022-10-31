package com.webservice.service.reqservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import premium.service.gen.GateWayRequest;


public class QuestionGateWay {
	
	
	
	public String BroadcastQuestion(GateWayRequest request) throws IOException, InterruptedException {		
		
	     
	     return Authentication(request);
		
	}
	
	
	public String Authentication(GateWayRequest data) throws IOException, InterruptedException {	
	
		HashMap<String, String> userlogin = new HashMap<String, String>();
		Gson gson = new Gson();
		
		userlogin.put("companyCode", data.getCompanyCode());		
		userlogin.put("password", data.getPassword());
		userlogin.put("username", data.getUsername());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/anything"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(userlogin)))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
	 
	     return response.body();
		
	}
	
	
	
	
	
	
	

}
