package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.User;
import com.example.demo.service.UserService;
@CrossOrigin
@RestController
public class UserController {


	@Autowired
	private UserService userService;
	
	//get all
	@GetMapping("/user")
	public Collection<User> getAll(){
		return userService.getAllUsers();
	}
	
	//get one
	@GetMapping("/user/{id}")
	public User getOne(@PathVariable ("id") Integer id) {
		return userService.getUserByID(id);
			
	}

	/*
	 * //get by name
	 * 
	 * @GetMapping("/user/{username}") public Collection<User>
	 * getByName(@PathVariable ("username") String username){ return
	 * userService.getUserByName(username); }
	 */
	//post
	@PostMapping("/user")
	public ResponseEntity<User> post(@RequestBody User user){		
		return userService.createUser(user);
	}
	//delete
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> delete(@PathVariable ("id") Integer id) {
		return userService.deleteUser(id);
	}
	//put
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user){
		
		return userService.updateUser(id, user);
	 }
	
}
