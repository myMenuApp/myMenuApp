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
		Restaurant pastaVilla = restaurantRepo.save(new Restaurant("Pasta Villa","An Fine Italian Restaurant in the OSU Campus area, owned and operated by the same family that owned Verdi in the Powell area. Delicious Food for a very reasonable price.",
				"Monday - Sunday 10AM to 10PM", "/img/pastavilla.png"));
		Restaurant fishMarket = restaurantRepo.save(new Restaurant("Mitchell's Fish Market","The Best SeaFood in Columbus, If shrimp cocktails, shrimp tartar, shrimp gumbo, shrimp and grits is your thing. This is the place to be.",
				"Monday - Sunday 11AM to 11PM", "/img/fishMarket.jpg"));
		Restaurant burgerBar = restaurantRepo.save(new Restaurant("Burger Bar", "The Burger Bar is the place to be. A casual burger concept in the Short North, that offers gourmet burgers at a casual price", 
				"Monday - Sunday 11AM to 9:30PM", "/img/burgerbar.jpg"));
		Restaurant winery = restaurantRepo.save(new Restaurant("Eleven Wine Bar", "Eleven Wine Bar, The premier wine bar in the Short North. Artisian Cooktails such as Barrel Aged Manhattan's, wines from all over the world, and a mwnu crafted by the chef's of Hyde Park.",
				"Friday & Saturday 4PM to 1AM", "/img/DEleven.jpg"));
		Restaurant ramen = restaurantRepo.save(new Restaurant("The Ramen Shop", "The finest Ramen shop in all of New Zeland. Our chefs use only the freshest imported foods, to make an esquised ramen.", 
				"Monday  - Saturaday 11AM - 8PM", "/img/ramen.png"));
		Restaurant domIan = restaurantRepo.save(new Restaurant("Dom & Ian's Place"));
//		Restaurant steakhouse = restaurantRepo.save(new Restaurant("Steakhouse"));
		Restaurant steakhouse = restaurantRepo.save(new Restaurant("Smith & Wollensky"));
		Restaurant chinese = restaurantRepo.save(new Restaurant("Taste of Orient"));
		
		Menu steakhouseAppetizers = menuRepo.save(new Menu("Appetizers", steakhouse));
		Menu pvAppetizers = menuRepo.save(new Menu("Pizza", pastaVilla));
		Menu pvDinner = menuRepo.save(new Menu("Dinner", pastaVilla));
		Menu specialitypizza = menuRepo.save(new Menu("Specialty Pizza", pastaVilla));
		Menu sandwichesDinner = menuRepo.save(new Menu("Sandwiches & Dinners", steakhouse));
		Menu lunch = menuRepo.save(new Menu("Dom & Ians Lunch Menu", domIan));
		Menu fmDinner = menuRepo.save(new Menu("Dinner", fishMarket));
		Menu fmSalad = menuRepo.save(new Menu("Salad", fishMarket));
		Menu lunchChinese = menuRepo.save(new Menu("Lunch", chinese));
		Menu dSteakhouse = menuRepo.save(new Menu("Dinner", steakhouse));
		Menu bBApps = menuRepo.save(new Menu("Appetizers", burgerBar));
		Menu bBBurgers = menuRepo.save(new Menu("Burgers", burgerBar));
		Menu bBShakes = menuRepo.save(new Menu("Milk Shakes", burgerBar));
		Menu elevenWine = menuRepo.save(new Menu("Wine List", winery));
		Menu elevenCocktails = menuRepo.save(new Menu("Cocktails", winery));
		Menu elevenFood = menuRepo.save(new Menu("Menu", winery));
		
		Item padThai = itemRepo.save(new Item("Pad Thai", "Stir fried rice noodles with bean sprouts, green onion, egg,and ground peanuts.", BigDecimal.valueOf(7.15),
                "/img/crabcakes.jpg", 940, "Nut, Gluten, Egg", true, lunchChinese));
        Item mongolian = itemRepo.save(new Item("Mongolian Beef", "Sauteed with spanish onion and green onion in a sweet garlic sauce.", BigDecimal.valueOf(7.35),
                "/img/crabcakes.jpg", 940, "Meat, Sugar", true, lunchChinese));
        Item szechuan = itemRepo.save(new Item("Szechuan Chicken", "Sauteed with mix vegetables in a spicy brown sauce.", BigDecimal.valueOf(6.95),
                "/img/crabcakes.jpg", 940, "Dairy, Gluten, Sugar", true, lunchChinese));
        Item ribEye = itemRepo.save(new Item("USDA Prime Boneless Rib Eye", "Pan Seared Then Smoked Rib Eye", BigDecimal.valueOf(55.00),
                "/img/crabcakes.jpg", 1320, "Beef", true, dSteakhouse));    
        Item nYStrip = itemRepo.save(new Item("USDA Prime Boneless New York Strip", "Grilled New York Strip Steak", BigDecimal.valueOf(54.00),
                "/img/crabcakes.jpg", 464, "Beef", true, dSteakhouse));    
        Item mignot = itemRepo.save(new Item("Signature Fillet Mignon", "Choice cuts of steak seared in butter", BigDecimal.valueOf(44.00),
                "/img/crabcakes.jpg", 757, "Beef, Dairy", true, dSteakhouse));
		
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
		
		Item bigStack = itemRepo.save(new Item("Big Stack", " Three 3oz locally sourced beef patties with American cheese, lettuce, dill pickle and our house made Special Sauce", BigDecimal.valueOf(13.00), "/img/bigstack.jpg", 1000,
				"ground beef, lettuce, special sauce, dill pickles", true, bBBurgers));
		Item buffNacho = itemRepo.save(new Item("Buffalo Chicken Nachos", " Nachos stacked tall with a buffalo cheese fondue, layered with chicken and topped with bleu cheese crumbles and celery", BigDecimal.valueOf(8.00), "/img/buffnacho.jpeg", 900,
				"cream cheese, buffalo, chicken, tri-colored chips", true, bBApps));
		Item buckeyeShake= itemRepo.save(new Item("Buckeye Shake", "The milkshake of the great state of Ohio, inspired by the buckeye candy. This shake will make any Xichigan fan reconsider!", BigDecimal.valueOf(7.00), "/img/buckShake.jpeg", 1000,
		"vanilla ice cream with peanut butter, cream, whip cream, peanuts", true, bBShakes));
		
		Item wine= itemRepo.save(new Item("Chardonnay", "A dry white wine, with hints of oak", BigDecimal.valueOf(13.00), "/img/chard.jpg", 300,
				"grapes", true, elevenWine));
		Item manhattan= itemRepo.save(new Item("Barrel Age Manhattan", " Woodford barrel aged manhattans, the perfect drink for a Friday evening", BigDecimal.valueOf(12.00), "/img/manhattan.jpg", 1000,
				"Woodford Burbon, orange, cherries and bitters", true, elevenCocktails));
				
		
//		Item tacoLaco = itemRepo.save(new Item("Taco Laco", "Large flour tortilla filled with taco meat topped with chilliA fried flour tortilla shaped like a bowl, filled with choice of ground beef or shredded chicken, topped with lettuce, sliced tomatoes, sour cream and shredded cheese.", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));
		
//		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));
//		
//		Item texasBurrito = itemRepo.save(new Item("Texas Burrito", "Large flour tortilla filled with taco meat topped with chilli con queso. Served with rice and  beans (with beef fajita/chicken fajita, add .75c)", BigDecimal.valueOf(8.25), "/img/.jpg", 780,
//				"ground beef, cheese, rice and beans", true, lunch));

	}
}