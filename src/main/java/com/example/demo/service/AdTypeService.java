package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.AdType;
import com.example.demo.repository.AdTypeRepository;

@Service
public class AdTypeService {
	
	@Autowired
	private AdTypeRepository adTypeRepository;
	

	
	public Collection<AdType> getAllAdTypes(){
		return adTypeRepository.findAll();
	}
	//getById
	
		public AdType getAdTypeByID(Integer typeId) {
			return adTypeRepository.findById(typeId).get();
		}
		
		//getByNaziv
	/*
	 * public Collection<AdType> getAdByName(String name){ return
	 * adTypeRepository.findByTypeContainingIgnoreCase(name); }
	 */
		//delete
	
		public ResponseEntity<AdType> deleteAdType(Integer id) {
			if(!adTypeRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			adTypeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		//post
		
		public ResponseEntity<AdType> createAdType( AdType adType){
			if(!adTypeRepository.existsById(adType.getAdTypeID())) {
				adTypeRepository.save(adType);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//update
	
		public ResponseEntity<AdType> updateAdType(Integer id, AdType adType){
			
		
		
			if(!adTypeRepository.existsById(id))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			AdType temp = adTypeRepository.findById(id).get();
			temp.setType(adType.getType());
			adTypeRepository.save(temp);
			return new ResponseEntity<>(HttpStatus.OK);
		 }
		
	

}
