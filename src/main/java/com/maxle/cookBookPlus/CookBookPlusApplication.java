package com.maxle.cookBookPlus;


import com.maxle.cookBookPlus.models.entities.Recipe;
import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.models.entities.WebResource;
import com.maxle.cookBookPlus.repositories.RecipeRepository;
import com.maxle.cookBookPlus.repositories.UserRepository;
import com.maxle.cookBookPlus.repositories.WebResourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CookBookPlusApplication {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RecipeRepository recipeRepo;
	@Autowired
	private WebResourceRepository wrRepo;


	public static void main(String[] args) {
		SpringApplication.run(CookBookPlusApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initDB(){
		addWebResources();

		Recipe r1 = new Recipe();
		r1.setName("Spaghetti");
		r1.setDescription("Classic italian spaghetti.");
		r1.setType("Family meal");
		this.recipeRepo.save(r1);
		this.recipeRepo.flush();


		User bill = new User();
		bill.setUsername("Billy");
		bill.setPassword("loveMicrosoft");
		bill.setEmail("bill@outlook.com");

		bill.setRecipes(new HashSet<Recipe>());
		bill.getRecipes().add(r1);
		this.userRepo.save(bill);
		this.userRepo.flush();


}

public void addWebResources(){
	WebResource w1 = new WebResource();
	w1.setName("Chocolate cake");
	w1.setDescription("An original & delicious cake for parties !");
	w1.setUrl("https://www.bbc.co.uk/food/recipes/easy_chocolate_cake_31070");
	this.wrRepo.save(w1);
	}


}
