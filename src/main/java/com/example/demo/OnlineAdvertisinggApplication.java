package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.example.demo.config"})
@ComponentScan({"com.example.demo.controllers"})
@ComponentScan({"com.example.demo.services"})
@ComponentScan({"com.example.demo.repository"})
@ComponentScan({"com.example.demo.models"})


public class OnlineAdvertisinggApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAdvertisinggApplication.class, args);
	}

}
