package se.martin.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import se.martin.jpa.model.Token;

public interface TokenRepository extends CrudRepository<Token, Long>{

	Token findTokenByUsername(String username);
}