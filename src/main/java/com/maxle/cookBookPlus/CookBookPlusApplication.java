package com.maxle.cookBookPlus;


import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CookBookPlusApplication {

	@Autowired
	private UserRepository userRepo;


	public static void main(String[] args) {
		SpringApplication.run(CookBookPlusApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initDB(){
		User u = new User();
		u.setUsername("Maxx");
		u.setPassword("132456");
		u.setEmail("max@coolmail.com");
		this.userRepo.save(u);
		this.userRepo.flush();
	}

}
