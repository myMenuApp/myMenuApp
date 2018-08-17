package com.HandCrest.myMenuApp;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long>{

	Restaurant findByRestaurantName(String restaurantName, String description);

	Restaurant findByRestaurantName(String restaurantName);

	}
