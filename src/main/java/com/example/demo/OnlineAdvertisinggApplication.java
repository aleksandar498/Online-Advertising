package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import lombok.val;


@SpringBootApplication
@ComponentScan({"com.example.demo.config"})
@ComponentScan({"com.example.demo.controllers"})
@ComponentScan({"com.example.demo.services"})
@ComponentScan({"com.example.demo.repository"})
@ComponentScan({"com.example.demo.models"})


public class OnlineAdvertisinggApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OnlineAdvertisinggApplication.class, args);
		
	}
	 @Autowired
	    DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
		val a = new FileSystemResource("insert.sql");
        
        val resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScripts(a);
        resourceDatabasePopulator.execute(dataSource);
		
	}

}
