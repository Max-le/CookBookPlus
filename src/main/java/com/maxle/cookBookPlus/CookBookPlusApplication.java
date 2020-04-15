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
import java.util.List;
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
		List<Recipe> recipes = addRecipes();

		User bill = new User();
		bill.setUsername("Billy");
		bill.setPassword("loveMicrosoft");
		bill.setEmail("bill@outlook.com");

		bill.setRecipes(new HashSet<>());
		bill.getRecipes().add(recipes.get(0));
		bill.getRecipes().add(recipes.get(2));
		this.userRepo.save(bill);
		this.userRepo.flush();


		User maxUser = new User();
		maxUser.setUsername("Max-le");
		maxUser.setPassword("wasabi");
		maxUser.setEmail("max.09@outlook.com");

		maxUser.setRecipes(new HashSet<>());
		maxUser.getRecipes().add(recipes.get(1));
		this.userRepo.save(maxUser);
		this.userRepo.flush();


}

public List<WebResource> addWebResources(){

	List<WebResource> resources = new ArrayList<>();

	WebResource w1 = new WebResource();
	w1.setName("Chocolate cake");
	w1.setDescription("An original & delicious cake for parties !");
	w1.setUrl("https://www.bbc.co.uk/food/recipes/easy_chocolate_cake_31070");
	this.wrRepo.save(w1);
	resources.add(w1);

	WebResource w2 = new WebResource();
	w2.setUrl("http://www.lafeestephanie.com/2020/04/pates-asiatiques-sautees-au-wok.html");
	w2.setDescription("Cuisine du monde, Pâtes");
	w2.setName("PÂTES ASIATIQUES SAUTÉES AU WOK");
	this.wrRepo.save(w2); this.wrRepo.flush();
	resources.add(w2);

	WebResource w3 = new WebResource();
	w3.setUrl("https://tasty.co/recipe/broccoli-soup");
	w3.setDescription("An easy and simple green soup");
	w3.setName("Brocolli soup");
	this.wrRepo.save(w3); this.wrRepo.flush();
	resources.add(w3);

	return resources;
	}

	public List<Recipe> addRecipes(){
		Recipe r1 = new Recipe();
		r1.setName("Spaghetti");
		r1.setDescription("Classic italian spaghetti.");
		r1.setType("Family meal");
		this.recipeRepo.save(r1);
		this.recipeRepo.flush();

		Recipe r2 = new Recipe();
		r2.setName("Soupe verte hivernale");
		r2.setDescription("Une somptueuse soupe pour vous réchauffer en hiver.");
		r2.setType("Vegan");
		this.recipeRepo.save(r2);
		this.recipeRepo.flush();

		Recipe r3 = new Recipe();
		r3.setName("Poulet au citron");
		r3.setDescription("Parce que le poulet et le citron font bon ménage");
		r3.setType("Plat principal");
		this.recipeRepo.save(r3);
		this.recipeRepo.flush();

		List<Recipe> recipes = new ArrayList<>();
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		return recipes;
	}


}
