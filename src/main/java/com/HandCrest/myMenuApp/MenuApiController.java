package com.HandCrest.myMenuApp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MenuApiController {

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
	@Autowired
	CommentRepository commentRepo;

	@RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
	public Collection<Item> deleteItem(@RequestParam(value = "restaurantName") String restaurantName,
			@RequestParam(value = "menuId") Long menuId, @RequestParam(value = "itemId") Long itemId) {
		for (Comment comment : itemRepo.findOne(itemId).getComments()) {
			commentRepo.delete(comment);
		}
		itemRepo.delete(itemId);
		return menuRepo.findOne(menuId).getItems();
	}

	@RequestMapping(value = "/menus", method = RequestMethod.DELETE)
	public Collection<Menu> deleteMenu(@RequestParam(value = "restaurantName") String restaurantName,
			@RequestParam(value = "menuId") Long menuId) {
		for (Item item : ((Menu) menuRepo.findOne(menuId)).getItems()) {
			for (Comment comment : item.getComments()) {
				commentRepo.delete(comment);
			}
			itemRepo.delete(item);
			}
			
		}
		menuRepo.delete(menuRepo.findOne(menuId));
		return restaurantRepo.findByRestaurantName(restaurantName).getMenus();
	}



