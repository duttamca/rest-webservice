package com.sanjiv.restclient;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sanjiv.model.Users;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestJersyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final String ENDPOINT_URL = "http://localhost:7001/UsersRestWS/rest/v1/users/";
		
		//httpPost(ENDPOINT_URL);
		//httpGet(ENDPOINT_URL,5);
		httpGet(ENDPOINT_URL);
		//httpDelete(ENDPOINT_URL);
		
		
	}
	
	
	private static void httpDelete(String endpointURL, int userid) {
		
		endpointURL = endpointURL + "delete/" +userid;
		System.out.println(endpointURL);
		httpDelete(endpointURL);
				
		
		
	}


	private static void httpGet(String endpointURL, int userid) {
		
		endpointURL = endpointURL +userid;
		System.out.println(endpointURL);
		httpGet(endpointURL);
		
		
	}


	private static void httpGet(String endpointURL){
		
		try {

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource(endpointURL);
			
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
	
	private static void httpPost(String endpointURL){
		
		try {

			Users user = new Users();
			user.setUserName("Avadh Sharma");
			user.setEmailID("avadhsharma@gmail.com");

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource(endpointURL);
			
			String request = new Gson().toJson(user);
			
			System.out.println(request);

			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class, request);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
	
	private static void httpDelete(String endpointURL){
		
		endpointURL = endpointURL + "delete/";
		System.out.println(endpointURL);
		
		try {

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource(endpointURL);
			
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
