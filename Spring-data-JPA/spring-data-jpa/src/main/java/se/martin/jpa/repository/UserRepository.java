package se.martin.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.martin.jpa.model.Team;
import se.martin.jpa.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByUsername(String username);

	List<User> findUserByTeam(Team team);
	
	List<User> findByFirstname(String firstname);

	List<User> findByLastname(String lastname);

	User findByUsername(String username);

	List<User> findUsersByTeamId(Long id);

	User findUserByUserNumber(String userNumber);

}