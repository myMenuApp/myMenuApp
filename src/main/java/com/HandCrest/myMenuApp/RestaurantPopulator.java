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
		Restaurant pastaVilla = restaurantRepo.save(new Restaurant("Pasta Villa"));
		Restaurant fishMarket = restaurantRepo.save(new Restaurant("Mitchell's Fish Market"));
		Restaurant burgerBar = restaurantRepo.save(new Restaurant("Burger Bar"));
		Restaurant winery = restaurantRepo.save(new Restaurant("The Wine and Dine"));
		Restaurant ramen = restaurantRepo.save(new Restaurant("The Ramen Shop"));
		Restaurant domIan = restaurantRepo.save(new Restaurant("Dom & Ian's Place"));
		Restaurant steakhouse = restaurantRepo.save(new Restaurant("Steakhouse"));
		
		Menu steakhouseAppetizers = menuRepo.save(new Menu("Appetizers", steakhouse));
		Menu pvAppetizers = menuRepo.save(new Menu("Pizza", pastaVilla));
		Menu pvDinner = menuRepo.save(new Menu("Dinner", pastaVilla));
		Menu specialitypizza = menuRepo.save(new Menu("Specialty Pizza", pastaVilla));
		Menu sandwichesDinner = menuRepo.save(new Menu("Sandwiches & Dinners", steakhouse));
		Menu lunch = menuRepo.save(new Menu("Dom & Ians Lunch Menu", domIan));
		Menu fmDinner = menuRepo.save(new Menu("Dinner", fishMarket));
		Menu fmSalad = menuRepo.save(new Menu("Salad", fishMarket));
		
		
		
		Item springSalad = itemRepo.save(new Item("Spring Salad", "Romaine Lettuce, Oil, Crutons, Cheese, Carrots, Eggs", BigDecimal.valueOf(45.00), 
				"/img/crabcakes.jpg", 145, "Egg, Dairy, Oil, Gluten",true, fmSalad));
		Item wedge = itemRepo.save(new Item("Titanic Wedge of Iceburg", "Iceburg Lettuce, Tomato, BlueCheese, Eggs", BigDecimal.valueOf(28.00), 
				"/img/crabcakes.jpg", 404, "Egg, Dairy",true, fmSalad));
		Item spinachGoat = itemRepo.save(new Item("Spinach and Goat Cheese Saladz	", "Iceburg Lettuce, Tomato, BlueCheese, Eggs", BigDecimal.valueOf(28.00), 
				"/img/crabcakes.jpg", 404, "Egg, Dairy",true, fmSalad));
		Item tuna = itemRepo.save(new Item("Seared Ahi Tuna", "Tuna, Oil", BigDecimal.valueOf(28.00), 
				"/img/crabcakes.jpg", 404, "Seafood, Oil",true, fmDinner));
		
		Item crispyCalamari = itemRepo.save(new Item("Chili Soy Dipping Sauce", "Soy, Chili", BigDecimal.valueOf(12.99), 
				"/img/crabcakes.jpg", 404, "Seafood, Oil",true, fmDinner));
		Item baconShrimp = itemRepo.save(new Item("Applewood Bacon Wrapped BBQ Shrimp", "Applewood Bacon, Shrimp, BBQ, Sticky Rice", BigDecimal.valueOf(24.00), 
				"/img/crabcakes.jpg", 908, "Seafood, Bacon, Shellfish, BBQ",true, fmDinner));
		Item calamri = itemRepo.save(new Item("Fried Calamari", "Squid, breaded and fried", BigDecimal.valueOf(4.99),
				"/img/crabcakes.jpg", 149, "seafood, seasame oil", true, pvAppetizers));
		Item cheeseBread = itemRepo.save(new Item("Cheese Bread", "Italian Baguette with Mozzarella Cheese", BigDecimal.valueOf(3.99),
				"/img/crabcakes.jpg", 225, "Gluten, Dairy", true, pvAppetizers));
		Item ravioli = itemRepo.save(new Item("Fried Ravioli", "Italian Sausage wrapped in pasta", BigDecimal.valueOf(4.99),
				"/img/crabcakes.jpg", 257, "Meat, Pasta, Oil", true, pvAppetizers));
		Item chickenparm = itemRepo.save(new Item("Chicken Parmigiana", "Breadded Chicken with Pizza Sauce and Mozzarella", BigDecimal.valueOf(13.99),
				"/img/crabcakes.jpg", 1200, "Gluten, Chicken, Oil, Tomato", true, pvDinner));
		Item veal = itemRepo.save(new Item("Veal Marasala", "Calf Cutlets, Pan Seared with Mushroom Sauce", BigDecimal.valueOf(13.00),
				"/img/crabcakes.jpg",525, "Meat, Mushroom", true, pvDinner));
		Item marcecata = itemRepo.save(new Item("Seafood Marcecata", "Angel Hair Pasta with Shirmp,Crab Meat, and Mussels", BigDecimal.valueOf(14.99),
				"/img/crabcakes.jpg", 857, "Seafood, Shell Fish, Oil, Pasta, Sauce", true, pvDinner));
		
		
		Item crabcakes = itemRepo.save(new Item("crabcakes", "cakes but made of crabs", BigDecimal.valueOf(786549.00),
				"/img/crabcakes.jpg", 350000, "imitation crab, birthday cake mix", true, steakhouseAppetizers));
		Item fishsticks = itemRepo.save(new Item("fishsticks", "fish in stick form", BigDecimal.valueOf(43520152.00),
				"/img/fishsticks.jpg", 100000, "Alaskan cod", true, steakhouseAppetizers));		
		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/texasburrito.jpg", 780,
				"ground beef, cheese, rice and beans", true, lunch));
		
		Item tostadas = itemRepo.save(new Item("Tostadas", "Two beef or chicken tostados with beans, lettuce, sour cream, guacamole, and cheese", BigDecimal.valueOf(43520152.00), "/img/tostados.jpg",
				100000, "beef or chicken tostados with beans, lettuce, sour cream, guacamole, and cheese", true, lunch));
	
		Item elSabino = itemRepo.save(new Item("El Sabino", "One cheese or chicken enchilada serve with rice, beans, and a cheese puff)", BigDecimal.valueOf(8.25), "/img/elSabino.jpg", 960,
				"chicken, cheese, rice and beans", true, lunch));
		Item hounddogs = itemRepo.save(new Item("Hounddogs", "Our Traditional thin crust served square cut.  Your choice of three of three mouth watering sauces-ORIGINAL, SPICE or HOWLIN' HOT.", BigDecimal.valueOf(15.99), "/img/elSabino.jpg", 2976,
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

