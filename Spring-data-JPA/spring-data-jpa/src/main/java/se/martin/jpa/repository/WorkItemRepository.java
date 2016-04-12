package se.martin.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.martin.jpa.model.Team;
import se.martin.jpa.model.User;
import se.martin.jpa.model.WorkItem;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long> {

	List<WorkItem> findByTitle(String title);

	List<WorkItem> findByDescription(String description);

	List<WorkItem> findByStatus(String status);

	List<WorkItem> findByTeam(Team team);

	List<WorkItem> findByUser(User user);

	List<WorkItem> findByDescriptionContaining(String description);

	List<WorkItem> findByIssueIdNotNull();

	List<WorkItem> findAllWorkItemsByUserId(Long id);

	List<WorkItem> findAllWorkItemsByTeamId(Long id);
}
