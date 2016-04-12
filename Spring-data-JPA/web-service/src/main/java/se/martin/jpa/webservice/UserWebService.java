package se.martin.jpa.webservice;

import java.net.URI;
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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import se.meer.jpa.model.User;
import se.meer.jpa.service.UserService;

@Path("users")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public final class UserWebService {

	@Context
	private UriInfo uriInfo;

	private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	private static UserService service = new UserService();

	static {
		context.scan("se.martin.jpa.config");
		context.refresh();
		service = context.getBean(UserService.class);
	}

	@POST
	public Response createUser(final User user) {
		user.addUserNumber();
		service.createOrUpdateUser(user);
		final String id = "id/" + user.getId();
		final URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.status(Status.CREATED).location(location).build();
	}

	@PUT
	@Path("id/{id}")
	public Response updateUserById(@PathParam("id") final Long id, final User user) {
		User userUpdate = service.findUserById(id);
		if (userUpdate != null) {
			userUpdate.setFirstname(user.getFirstname());
			userUpdate.setLastname(user.getLastname());
			userUpdate.setUsername(user.getUsername());
		}
		service.createOrUpdateUser(user);
		return Response.ok().entity(user).build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteUserById(@PathParam("id") final Long id) {
		try {
			service.deleteUserById(id);
			return Response.ok("User with id " + id + " Deleted").build();
		} catch (EmptyResultDataAccessException e) {
			return Response.status(Status.NOT_FOUND).entity("Could not find user with id: " + id).build();
		}
	}

	@GET
	@Path("usernumber/{userNo}")
	public Response findUserByUserNumber(@PathParam("userNo") final String userNumber) {
		User user = service.findUserByUserNo(userNumber);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("id/{id}")
	public Response findUserById(@PathParam("id") final Long id) {
		final User user = service.findUserById(id);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("/firstname/{firstname}")
	public Response findUserByFirstname(@PathParam("firstname") final String firstname) {
		final List<User> user = service.findUserByFirstname(firstname);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("/lastname/{lastname}")
	public Response findUserByLastname(@PathParam("lastname") final String lastname) {
		final List<User> user = service.findUserByLastname(lastname);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("/username/{username}")
	public Response findUserByUsername(@PathParam("username") final String username) {
		final User user = service.findUserByUsername(username);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("/team/{teamId}")
	public Response findAllUsersInTeam(@PathParam("teamId") final Long teamId) {
		List<User> users = service.findUsersByTeamId(teamId);
		return Response.ok().entity(users).build();
	}
}