package com.sanjiv.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sanjiv.model.Users;

public interface UsersResourceInterface {
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsers();
	
	
	public Users getUser(int userid);

}
