package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.AdType;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public Collection<User> getAllUsers(){
		return userRepository.findAll();
	}
	//getById
	
		public User getUserByID(Integer Id) {
			return userRepository.findById(Id).get();
		}
		
		//getByNaziv
	
		public User getUserByName(String username){
			return (User) userRepository.findByUsernameContainingIgnoreCase(username);
		}
		
		//delete
	
		public ResponseEntity<User> deleteUser(Integer id) {
			if(!userRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		//post
		
		public ResponseEntity<User> createUser( User user){
			if(!userRepository.existsById(user.getUserID())) {
				userRepository.save(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//update
	
		public ResponseEntity<User> updateUser(int id, User user){
			if(!userRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			User temp = userRepository.findById(user.getUserID()).get();
			temp.setUsername(user.getUsername());
			temp.setPassword(user.getPassword());
			temp.setPhoneNumber(user.getPhoneNumber());
			temp.setRegistrationDate(user.getRegistrationDate());
			userRepository.save(temp);
			return new ResponseEntity<>(HttpStatus.OK);
			
			
		 }
		
	
}
