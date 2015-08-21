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

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjiv.model.Users;
import com.sanjiv.service.UserService;

@Path("/v1")

public class UserResource implements UserResourceInterface{

/*	UsersService userService = new UsersService(new UsersDao
									(HibernateUtility.buildSessionFactory()));*/
	
	@Context
	private UriInfo uriInfo;
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UserService userService = (UserService) context.getBean("userService");
		
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsers() {
		List<Users> usersList = new ArrayList<Users>();
		usersList = userService.getUsers();

		return usersList;
	}
	
	/*@GET
	@Path("/users")
	@Produces("application/javascript")
	public JSONWithPadding getUsers( @QueryParam("callback") String callback) {
		List<Users> usersList = new ArrayList<Users>();
		usersList = userService.getUsers();

		return new JSONWithPadding(usersList,callback);
	}
	*/
	
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
	public Response saveUser(Users user){
				
		userService.addUser(user);
		
		return Response.ok().build();
	}
	
	@PUT
	public Response updateUser(Users user){
		userService.updateUser(user);
		return Response.ok().build();
	}
		
}


