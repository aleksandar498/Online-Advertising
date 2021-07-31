package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AdType;
import com.example.demo.service.AdTypeService;


import org.springframework.http.ResponseEntity;
@CrossOrigin
@RestController
public class AdTypeController {
	
	@Autowired
	private AdTypeService adTypeService;
	
	//get all
	@GetMapping("/adtype")
	public Collection<AdType> getAll(){
		return adTypeService.getAllAdTypes();
	}
	
	//get one
	@GetMapping("/adtype/{id}")
	public AdType getOne(@PathVariable ("id") Integer id) {
		return adTypeService.getAdTypeByID(id);
			
	}
	//get by name
	/*
	 * @GetMapping("/adtype/{name}") public Collection<AdType>
	 * getByName(@PathVariable ("name") String name){ return
	 * adTypeService.getAdByName(name); }
	 */
	//post
	@PostMapping("/adtype")
	public ResponseEntity<AdType> post(@RequestBody AdType adType){		
		return adTypeService.createAdType(adType);
	}
	//delete
	@DeleteMapping("/adtype/{id}")
	public ResponseEntity<AdType> delete(@PathVariable ("id") Integer id) {
		return adTypeService.deleteAdType(id);
	}
	//put
	@PutMapping("/adtype/{id}")
	public ResponseEntity<AdType> update(@PathVariable int id, @RequestBody AdType adType){
		
		return adTypeService.updateAdType(id, adType);
	 }
	
}
