package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Ad;
import com.example.demo.repository.AdRepository;

@Service
public class AdService {

	@Autowired
	private AdRepository adRepository;
	

	public Collection<Ad> getAllAds(){
		return adRepository.findAll();
	}
	//getById
	
		public Ad getAdByID(Integer Id) {
			return adRepository.findById(Id).get();
		}
		
		//getByNaziv
	
		public Collection<Ad> getAdByName(String name){
			return adRepository.findByNameContainingIgnoreCase(name);
		}
		
		//delete
	
		public ResponseEntity<Ad> deleteAd(Integer id) {
			if(!adRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			adRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		//post
		
		public ResponseEntity<Ad> createAd( Ad ad){
			if(!adRepository.existsById(ad.getID())) {
				adRepository.save(ad);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//update
	
		public ResponseEntity<Ad> updateAd(int id, Ad ad){
			
			if(!adRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
				Ad temp = adRepository.findById(ad.getID()).get();
				temp.setName(ad.getName());
				temp.setDescription(ad.getDescription());
				temp.setDateAdded(ad.getDateAdded());
				temp.setUrl(ad.getUrl());
				temp.setPrice(ad.getPrice());
				temp.setCity(ad.getCity());
				temp.setAdType(ad.getAdType());
				temp.setUser(ad.getUser());
				
				adRepository.save(temp);
				return new ResponseEntity<>(HttpStatus.OK);
			
			
			
			
			
		 }
		
	
}
