package com.sanjiv.restws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjiv.dao.UsersDao;
import com.sanjiv.model.Users;
import com.sanjiv.service.UsersService;
import com.sanjiv.utility.ConnectionHelper;
import com.sanjiv.utility.HibernateUtility;
import com.sun.jersey.json.impl.provider.entity.JSONArrayProvider;

@Path("/v1")

public class UsersResource implements UsersResourceInterface{
	

	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	UsersService userService = (UsersService) context.getBean("userService");
		
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsers() {
		List<Users> usersList = new ArrayList<Users>();
		usersList = userService.getUsers();

		return usersList;
	}
	
	
	@GET
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Users getUser(@PathParam("userid") int userid) {
		Users user = userService.getUserById(userid);
		return user;
	}
	
	@DELETE
	@Path("/users/delete/{userid}")
	public Response deleteUser(@PathParam("userid")int userid){
		userService.deleteUser(userid);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/users/delete")
	public Response deleteUsers(){
		userService.deleteUsers();
		return Response.ok().build();
	}
	
	/*@POST
	@Consumes("application/json")
	@Path("/users/{username}-{emailid}")
	public Response saveUser(@PathParam("username") String userName,@PathParam("emailid") String emailID){
		
		Users user = new Users();
		user.setEmailID(emailID);
		user.setUserName(userName);
		
		userService.addUser(user);
		
		return Response.ok().build();
	}*/
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveUser(Users user){
				
		userService.addUser(user);
		
		return Response.ok().build().toString();
	}
	
	@PUT
	public Response updateUser(Users user){
		userService.updateUser(user);
		return Response.ok().build();
	}
		
}


