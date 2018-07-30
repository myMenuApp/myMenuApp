package com.HandCrest.myMenuApp;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)

public class MenuControllerTest {

	@Resource
	MockMvc mvc;

	@MockBean
	ItemRepository itemRepo;
	@MockBean
	MenuRepository menuRepo;
	@MockBean
	ManagerRepository managerRepo;
	@MockBean
	CustomerRepository customerRepo;
	@MockBean
	ReviewRepository reviewRepo;
	@MockBean
	RestaurantRepository restaurantRepo;

	@Mock
	Item item;
	@Mock
	Menu menu;
	@Mock
	Manager manager;
	@Mock
	Customer customer;
	@Mock
	Review review;
	@Mock
	Restaurant restaurant;


}
