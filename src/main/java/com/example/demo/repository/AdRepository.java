package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
	Collection<Ad>findByNameContainingIgnoreCase(String name);

}
