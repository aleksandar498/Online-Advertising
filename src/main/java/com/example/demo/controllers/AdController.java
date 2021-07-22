package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Ad;
import com.example.demo.service.AdService;


@RestController
public class AdController {

	@Autowired
	private AdService adService;
	
	//get all
	@GetMapping("/ad")
	public Collection<Ad> getAll(){
		return adService.getAllAds();
	}
	
	//get one
	@GetMapping("/ad/{id}")
	public Ad getOne(@PathVariable ("id") Integer id) {
		return adService.getAdByID(id);
			
	}
	//get by name
	@GetMapping("/ad/{name}")
	public Collection<Ad> getByName(@PathVariable ("name") String name){
		return adService.getAdByName(name);
	}
	//post
	@PostMapping("/ad")
	public ResponseEntity<Ad> post(@RequestBody Ad adType){		
		return adService.createAd(adType);
	}
	//delete
	@DeleteMapping("/ad/{id}")
	public ResponseEntity<Ad> delete(@PathVariable ("id") Integer id) {
		return adService.deleteAd(id);
	}
	//put
	@PutMapping("/ad/{id}")
	public ResponseEntity<Ad> update(@PathVariable int id, @RequestBody Ad adType){
		
		return adService.updateAd(id, adType);
	 }
}
