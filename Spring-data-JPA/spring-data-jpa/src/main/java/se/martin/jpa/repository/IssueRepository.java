package se.martin.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import se.martin.jpa.model.Issue;

public interface IssueRepository extends CrudRepository<Issue, Long> {
}
