package se.martin.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import se.martin.jpa.service.IssueService;
import se.martin.jpa.service.TeamService;
import se.martin.jpa.service.TokenService;
import se.martin.jpa.service.UserService;
import se.martin.jpa.service.WorkItemService;

/**
 * @author M
 *
 */
@Configuration
public class ServiceConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public TeamService teamService() {
		return new TeamService();
	}

	@Bean
	public WorkItemService workItemService() {
		return new WorkItemService();
	}

	@Bean
	public IssueService issueService() {
		return new IssueService();
	}
	
	@Bean
	public TokenService tokenService() {
		return new TokenService();
	}
}