package com.HandCrest.myMenuApp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FreezeApiController {

	@Autowired
	RestaurantRepository restaurantRepo;
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	ManagerRepository managerRepo;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	ReviewRepository reviewRepo;

	@RequestMapping(value = "/index", method = RequestMethod.PUT)
	public Collection<Item> patchItem(
			@RequestParam(value = "menuId") Long menuId,
			@RequestParam(value = "itemId") Long itemId) {
		Item itemToPatch = itemRepo.findOne(itemId);
		if (itemToPatch != null) {
			itemToPatch.toggleEnabled();
			itemRepo.save(itemToPatch);
		}
		return menuRepo.findOne(menuId).getItems();
	}
}
