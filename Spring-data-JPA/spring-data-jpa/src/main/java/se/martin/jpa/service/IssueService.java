package se.martin.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;

import se.martin.jpa.model.Issue;
import se.martin.jpa.repository.IssueRepository;

public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	public Issue createOrUpdateIssue(Issue issue) {
		return issueRepository.save(issue);
	}

	public Issue findIssueById(Long id) {
		Issue issue = issueRepository.findOne(id);
		return issue;
	}

}
