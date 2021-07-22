package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan({"com.example.demo.controllers"})

public class OnlineAdvertisinggApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAdvertisinggApplication.class, args);
	}

}
