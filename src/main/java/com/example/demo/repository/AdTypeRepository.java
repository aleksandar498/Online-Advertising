package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AdType;


@Repository
public interface AdTypeRepository extends JpaRepository<AdType, Integer> {
	Collection<AdType>findByTypeContainingIgnoreCase(String type);

}
