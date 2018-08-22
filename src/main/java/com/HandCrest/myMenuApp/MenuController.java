
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
	
	
	@RequestMapping("/index")
	public String getRestaurants(Model model) {
		model.addAttribute("restaurants", restaurantRepo.findAll());
		return "index";
	}
	
	@RequestMapping("/index/admin")
	public String getLogin(Model model) {
		model.addAttribute("restaurants", restaurantRepo.findAll());
		return "admin";
	}
	
	@RequestMapping("/index/contact")
	public String getContact(Model model) {
		return "contact";
	}
	
	@RequestMapping("index/admin/{restaurantName}")
	public String getRestaurant(@PathVariable(name = "restaurantName")String restaurantName, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		return "restaurant";
	}
	@RequestMapping("/index/aboutUs")
	public String getAboutUs(Model model) {
		model.addAttribute("aboutUs");
		return "aboutUs";
}

	@RequestMapping("/index/{restaurantName}/menus/{menuId}")
	public String getMenu(@PathVariable(name = "restaurantName")String restaurantName,
							@PathVariable(name = "menuId") Long menuId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		return "menu";
	}

	@RequestMapping("/index/{restaurantName}/menus/{menuId}/items/{itemId}")
		public String getItem(@PathVariable(name = "restaurantName")String restaurantName,
								@PathVariable(name = "menuId")Long menuId,
								@PathVariable(name = "itemId")Long itemId, Model model) {
		model.addAttribute("restaurant", restaurantRepo.findByRestaurantName(restaurantName));
		model.addAttribute("menu", menuRepo.findOne(menuId));
		model.addAttribute("item", itemRepo.findOne(itemId));
		return "item";
	}
	
/*	@RequestMapping("index/{restaurantName}/admin")
		public String getRestaurantAdmin(@PathVariable(name = "restaurantName") String restaurantName, Model model) {
			return "admin";
		
	}*/
	
}
	
