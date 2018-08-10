package com.HandCrest.myMenuApp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class RestaurantPopulator implements CommandLineRunner {
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	RestaurantRepository restaurantRepo;
	@Autowired
	ManagerRepository managerRepo;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Restaurant steakhouse = restaurantRepo.save(new Restaurant("The Steakhouse"));
		Restaurant fishMarket = restaurantRepo.save(new Restaurant("The Fish Market"));
		Restaurant burgerBar = restaurantRepo.save(new Restaurant("Burger Bar"));
		Restaurant winery = restaurantRepo.save(new Restaurant("The Wine and Dine"));
		Restaurant ramen = restaurantRepo.save(new Restaurant("The Ramen Shop"));
		Menu steakhouseAppetizers = menuRepo.save(new Menu("Appetizers", steakhouse));
		Item crabcakes = itemRepo.save(new Item("crabcakes", "cakes but made of crabs", BigDecimal.valueOf(786549.00),
				"/img/crabcakes.jpg", 350000, "imitation crab, birthday cake mix", true, steakhouseAppetizers));
		Item fishsticks = itemRepo.save(new Item("fishsticks", "fish in stick form", BigDecimal.valueOf(43520152.00),
				"/img/fishsticks.jpg", 100000, "Alaskan cod", true, steakhouseAppetizers));
			
		Restaurant domIan = restaurantRepo.save(new Restaurant("Dom & Ian's Place"));
		
		Menu lunch = menuRepo.save(new Menu("Dom & Ians Lunch Menu", domIan));
		
		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/texasburrito.jpg", 780,
				"ground beef, cheese, rice and beans", true, lunch));
		
		Item tostadas = itemRepo.save(new Item("Tostadas", "Two beef or chicken tostados with beans, lettuce, sour cream, guacamole, and cheese", BigDecimal.valueOf(43520152.00), "/img/tostados.jpg",
				100000, "beef or chicken tostados with beans, lettuce, sour cream, guacamole, and cheese", true, lunch));
	
		Item elSabino = itemRepo.save(new Item("El Sabino", "One cheese or chicken enchilada serve with rice, beans, and a cheese puff)", BigDecimal.valueOf(8.25), "/img/elSabino.jpg", 960,
				"chicken, cheese, rice and beans", true, lunch));
		
//		Item tacoLaco = itemRepo.save(new Item("Taco Laco", "Large flour tortilla filled with taco meat topped with chilliA fried flour tortilla shaped like a bowl, filled with choice of ground beef or shredded chicken, topped with lettuce, sliced tomatoes, sour cream and shredded cheese.", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));
		
//		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));
//		
//		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));

	}
}

