package com.maxle.cookBookPlus;

import com.maxle.cookBookPlus.entities.User;
import com.maxle.cookBookPlus.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CookBookPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookPlusApplication.class, args);
	}


}
