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
		Restaurant crapplebees = restaurantRepo.save(new Restaurant("Crapplebee's"));
		Menu crapplebeesSeasonal = menuRepo.save(new Menu("Crapplebee's Seasonal Menu", crapplebees));
		Item crabcakes = itemRepo.save(new Item("crabcakes", "cakes but made of crabs", BigDecimal.valueOf(420.00), "/img/crabcakes.jpg", 666,
				"crabs, cakes", crapplebeesSeasonal));
		Item fishsticks = itemRepo.save(new Item("fishsticks", "fish in stick form", BigDecimal.valueOf(69.00), "/img/fishsticks.jpg",
				666, "Alaskan cod dick", crapplebeesSeasonal));
	}

}
