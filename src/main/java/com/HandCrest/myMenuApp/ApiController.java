package com.HandCrest.myMenuApp;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
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

	// add item to current menu
	@RequestMapping(value = "/menu/{menuId}/items", method = RequestMethod.POST)
	public Collection<Item> addItem(@PathVariable(name = "menuId") Long menuId,
			@RequestParam(value = "itemName") String itemName, @RequestParam(value = "description") String description,
			@RequestParam(value = "price") String price, @RequestParam(value = "picture") String picture,
			@RequestParam(value = "calories") int calories, @RequestParam(value = "ingredients") String ingredients) {
		BigDecimal bigDecimalPrice = new BigDecimal(price);
		itemRepo.save(new Item(itemName, description, bigDecimalPrice, picture, calories, ingredients,
				menuRepo.findOne(menuId)));
		return menuRepo.findOne(menuId).getItems();
	}

	// add menu to current restaurant
	@RequestMapping(value = "/index/{restaurantName}/menus", method = RequestMethod.POST)
	public Collection<Menu> addMenu(@PathVariable(name = "restaurantName") String restaurantName,
			@RequestParam(value = "menuName") String menuName) {
		menuRepo.save(new Menu(menuName, restaurantRepo.findByRestaurantName(restaurantName)));
		return restaurantRepo.findByRestaurantName(restaurantName).getMenus();
	}

	// edit Item properties
	@RequestMapping(value = "/menus/{menuId}/items/{itemId}", method = RequestMethod.PUT)
	public Item editItem(@PathVariable(name = "menuId") Long menuId, @PathVariable(name = "itemId") Long ItemId,
			@RequestParam(value = "itemName", required = false) String itemName,
			@RequestParam(value = "picture", required = false) String picture,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "calories", required = false) Integer calories,
			@RequestParam(value = "ingredients", required = false) String ingredients) {
		Item item = itemRepo.findOne(ItemId);
		if (itemName != null) {
			item.setItemName(itemName);
		}
		if (picture != null) {
			item.setPicture(picture);
		}
		if (description != null) {
			item.setDescription(description);
		}
		if (price != null) {
			BigDecimal bigDecimalPrice = new BigDecimal(price);
			item.setPrice(bigDecimalPrice);
		}
		if (calories != null) {
			item.setCalories(calories);
		}
		if (ingredients != null) {
			item.setIngredients(ingredients);
		}
		itemRepo.save(item);
		return itemRepo.findOne(ItemId);
	}

	// edit Menu properties
	@RequestMapping(value = "menus/{menuId}", method = RequestMethod.PUT)
	public Menu editMenu(@PathVariable(name = "menuId") Long menuId,
						@RequestParam(value = "menuName") String menuName) {
		Menu menu = menuRepo.findOne(menuId);
		if (menuName != null) {
			menu.setMenuName(menuName);
		}
		menuRepo.save(menu);
		return menuRepo.findOne(menuId);
	}
}
