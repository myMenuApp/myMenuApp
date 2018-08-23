package com.HandCrest.myMenuApp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {
	@Resource
	TestRestTemplate restTemplate;
		
	//If this was a database entry into a restaurant table, to populate my "restaurant" object I would search for name
	// and populate the menu ID and item ID associated with Mitchell's Fish Market (this has changed multiple times, I need to know this)
	String restaurantName = "Fish Market";
	Long menuId = (long) 7;
	Long itemId = (long) 7;
	String picture = "/img/milk.jpg";

	@Test public void canary() { // test we can find localhost:8080/
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldFindHomePage() { // test to show a path to the home page
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	@Test public void shouldNotFindHomePage() { // test to show a path to the home page is broken
		ResponseEntity<String> response = restTemplate.getForEntity("/custome", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test public void shouldFindRestaurantPage() {  // test to show a path to the restaurant page
		ResponseEntity<String> response = restTemplate.getForEntity("/index/customer/{restaurantName}", String.class, restaurantName);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}	
	
	@Test public void shouldNotFindRestaurantBecauseItHasASpellingMistake() { // test to show that wrong spelling will show NOT_FOUND error
		ResponseEntity<String> response = restTemplate.getForEntity("/customer/The Steakhous", String.class, restaurantName);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
		
	@Test public void shouldFindMenu() { // test to show a path to restaurant menu
		ResponseEntity<String> response = restTemplate.getForEntity("/index/customer/{restaurantName}/menus/{menuId}", String.class, restaurantName, menuId);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldFindItem() { // test to show a path to the restaurants / menu / item 
		//ResponseEntity<String> response = restTemplate.getForEntity("/customer/Mitchell's Fish Market/menus/7/items/10", String.class, restaurantName, menuId, itemId);
		ResponseEntity<String> response = restTemplate.getForEntity("/customer/{restaurantName}/menus/{menuId}/items/{itemId}", String.class, restaurantName, menuId, itemId);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
}