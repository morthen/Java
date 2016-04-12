package se.grouprich.projectmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import se.grouprich.projectmanagement.model.Issue;
import se.grouprich.projectmanagement.model.WorkItem;

public interface IssueRepository extends CrudRepository<Issue, Long>
{
	@Query("SELECT i.workItem FROM #{#entityName} i")
	List<WorkItem> findWorkItemsHavingIssue();
	
	@Transactional
	List<Issue> removeByWorkItem(WorkItem workItem);
}
