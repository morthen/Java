package se.martin.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import se.martin.jpa.model.Team;
import se.martin.jpa.model.User;
import se.martin.jpa.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User createOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}

	public List<User> findUserByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname);
	}

	public List<User> findUserByLastname(String lastname) {
		return userRepository.findByLastname(lastname);
	}

	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findUserByUserNo(String userNumber) {
		return userRepository.findUserByUserNumber(userNumber);
	}

	public List<User> findUsersByTeam(Team team) {
		List<User> users = new ArrayList<>();
		users.addAll(userRepository.findUserByTeam(team));
		return users;
	}
	
	public List<User> findUsersByTeamId(Long id) {
		List<User> users = new ArrayList<>();
		users.addAll(userRepository.findUsersByTeamId(id));
		return users;
	}

	public Long deleteUserById(Long id) {
		userRepository.delete(id);
		return id;
	}

	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}

	
}