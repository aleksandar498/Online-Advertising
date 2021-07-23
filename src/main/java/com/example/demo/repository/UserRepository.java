package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Collection<User>findByUsernameContainingIgnoreCase(String username);
	User findByUsername(String username); 

}
