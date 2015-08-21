package com.sanjiv.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RestClient {
	
	public static void main(String args[]){
		
		
		final String REST_ENDPOINT = "http://localhost:7001/UsersRestWS/rest/v1/users/";
		
		String getRequestOutput = httpGet(REST_ENDPOINT);
		System.out.println(getRequestOutput);
		
		
		
	}
	
	public static String httpGet(String urlString){
		
		HttpURLConnection connection = null;
		StringBuilder sb = null;
		
		try {
			
			URL endpointUrl = new URL(urlString);
			connection = (HttpURLConnection)endpointUrl.openConnection();
			
			if (connection.getResponseCode() != 200) {
			    throw new IOException(connection.getResponseMessage());
			  }
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			
			//System.out.println(sb.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}
	
	public static String httpPost(String urlString){
		
		HttpURLConnection connection = null;
		StringBuilder sb = null;
		
		try {
			
			URL endPointURL = new URL(urlString);
			connection = (HttpURLConnection) endPointURL.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept","application/json");
			
			BufferedReader rd = new BufferedReader(
				      new InputStreamReader(connection.getInputStream()));
			
			sb = new StringBuilder();
			
			String line;
			  while ((line = rd.readLine()) != null) {
			    sb.append(line);
			  }
			  rd.close();

			  connection.disconnect();
			  
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

}
