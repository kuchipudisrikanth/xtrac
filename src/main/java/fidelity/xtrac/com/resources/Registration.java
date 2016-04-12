package fidelity.xtrac.com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fidelity.xtrac.com.model.Application;
import fidelity.xtrac.com.model.User;
import fidelity.xtrac.com.service.UserService;


@Path("xtrac")
public class Registration {

	UserService  userService = new UserService(); 



	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("email") String email) {
		System.out.println("email : "+ email);
		return userService.getUser(email);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		System.out.println("Adding User : "+ user);
		return userService.addUser(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		System.out.println("updating User : "+ user);
		return userService.updateUser(user);
	}

	@DELETE
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("email") String email) {
		System.out.println("deleting User : "+ email);
		userService.deleteUser(email);
	}

	@POST
	@Path("/addApp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Application registerApplication(Application application) {
		System.out.println("Adding Application : "+ application);
		return userService.registerApplication(application);
	}


	@GET
	@Path("/{email}/getAppsByEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Application> getApplicationByEmail(@PathParam("email") String email) {

		//System.out.println("List Applications for user: "+ email);
		return userService.getApplicationByEmail(email);
	}

	@DELETE
	@Path("/{email}/deleteAppByAppID/{appId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAppByAppID(@PathParam("email") String email,@PathParam("appId") Long appId) {
		System.out.println("delete Application for user: "+ email +" and app Id :"+appId);
		userService.deleteAppByAppID(email, appId);
	}

}
