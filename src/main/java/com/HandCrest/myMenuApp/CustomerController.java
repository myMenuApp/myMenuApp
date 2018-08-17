package com.HandCrest.myMenuApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

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
	RestaurantRepository restaurantRepo;
	
	@RequestMapping("/customer/{restaurantName}/menus/{menuId}")
	public String getCustomerMenu(@PathVariable(name = "restaurantName")String restaurantName,
							@PathVariable(name = "menuId") Long menuId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		return "customerMenu";
	}
	
	@RequestMapping("/customer/{restaurantName}/menus/{menuId}/items/{itemId}")
	public String getItem(@PathVariable(name = "restaurantName")String restaurantName,
			@PathVariable(name = "menuId")Long menuId,
			@PathVariable(name = "itemId")Long itemId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		model.addAttribute("items", itemRepo.findOne(itemId));
		return "CustomerItem";
	}
	@RequestMapping("index/customer/{restaurantName}")
	public String getRestaurant(@PathVariable(name = "restaurantName")String restaurantName, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		return "customerRestaurant";
	}
}
