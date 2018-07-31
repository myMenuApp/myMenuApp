package com.HandCrest.myMenuApp;

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
		Item crabcakes = itemRepo
				.save(new Item("crabcakes", "cakes but made of crabs", 9.99, "imgPath", 666, "crabs, cakes"));
		Menu crapplebeesSeasonal = menuRepo.save(new Menu("Crapplebee's Seasonal Menu", crabcakes));
		Restaurant crapplebees = restaurantRepo.save(new Restaurant("Crapplebee's", crapplebeesSeasonal));
	}

}
