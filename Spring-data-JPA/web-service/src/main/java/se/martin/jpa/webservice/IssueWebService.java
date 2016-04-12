package se.martin.jpa.webservice;

import java.net.URI;

import javax.ws.rs.Consumes;
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
import org.springframework.stereotype.Component;

import se.meer.jpa.model.Issue;
import se.meer.jpa.service.IssueService;
import se.meer.jpa.service.TeamService;
import se.meer.jpa.service.UserService;
import se.meer.jpa.service.WorkItemService;

@Component
@Path("issues")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class IssueWebService {

	@Context
	private UriInfo uriInfo;

	private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	private static IssueService service = new IssueService();

	static {
		context.scan("se.martin.jpa.config");
		context.refresh();
		service = context.getBean(IssueService.class);
	}

	@POST
	public Response createIssue(final Issue issue) {
		service.createOrUpdateIssue(issue);
		final String id = "id/" + issue.getId();
		final URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(location).build();
	}

	@PUT
	@Path("id/{id}")
	public Response updateIssueById(@PathParam("id") final Long id, final Issue issue) {
		Issue issueUpdate = service.findIssueById(id);
		if (issueUpdate != null) {
			issueUpdate.setDescription(issue.getDescription());
			issueUpdate.setTitle(issue.getTitle());
			service.createOrUpdateIssue(issue);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Could not find issue with id: " + id).build();
		}
	}
}