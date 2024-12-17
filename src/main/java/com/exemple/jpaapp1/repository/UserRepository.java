package com.exemple.jpaapp1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.User;


public interface UserRepository extends CrudRepository<User,Integer>{

	Optional<User> findById(Long id);

	void deleteById(Long id);

}
