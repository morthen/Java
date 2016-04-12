package se.martin.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import se.martin.jpa.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
