package com.HandCrest.myMenuApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
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
	
	
	@RequestMapping ("/")
	public String home(Model model) {
		return "redirect:/index";
	}
	
	@RequestMapping("/restaurants")
	public String getRestaurants(Model model) {
		model.addAttribute("restaurants", restaurantRepo.findAll());
		return "restaurants";
	}
	@RequestMapping("/restaurants/{restaurantName}")
	public String getRestaurant(@PathVariable(name = "restaurantName")String restaurantName, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		return "restaurant";
	}
	@RequestMapping("/restaurants/{restaurantName}/{menuId}")
	public String getMenu(@PathVariable(name = "restaurantName")String restaurantName,
							@PathVariable(name = "menuId") Long menuId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		return "menu";
	}

	@RequestMapping("/restaurants/{restaurantName}/{menuId}/{itemId}")
		public String getItem(@PathVariable(name = "restaurantName")String restaurantName,
								@PathVariable(name = "menuId")Long menuId,
								@PathVariable(name = "itemId")Long itemId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		model.addAttribute("items", itemRepo.findOne(itemId));
		return "item";
	}
	
}
	
