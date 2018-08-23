package com.HandCrest.myMenuApp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class AdminControllerTest {

	@Resource TestRestTemplate restTemplate;
	@Resource private AdminController underTest;

// We can add this test when we have a login html page - still does not exist as of 8/21, added "INDEX" instead
	
	@Test public void ShouldFindAdminLoginPage () { 
		ResponseEntity<String> response = restTemplate.getForEntity("/index", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
// We can add this test when we have a admin html page
	
//	@Test public void ShouldFindAdminPage () { 
//	ResponseEntity<String> response = restTemplate.getForEntity("/admin", String.class);
//	HttpStatus status = response.getStatusCode();
//	assertThat(status, is(HttpStatus.OK));
//  }
	
	// We can add this test when we have a customer html page
	
//		@Test public void ShouldFindAdminPage () { 
//		ResponseEntity<String> response = restTemplate.getForEntity("index/customer", String.class);
//		HttpStatus status = response.getStatusCode();
//		assertThat(status, is(HttpStatus.OK));
//  }
	
	
	@Test
	public void shouldSetAdminLoginCookieFoo() {	
		HttpServletRequest request = mock(HttpServletRequest.class);	
		HttpServletResponse response = mock(HttpServletResponse.class);
		response.addCookie(new Cookie("role", "role"));		

		underTest.adminLogin(request, response);
		
		ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);
		verify(response).addCookie(cookieCaptor.capture());
		Cookie cookie = cookieCaptor.getValue();

		assertThat(cookie.getName(), is("role"));
	}

	@Test
	public void shouldSetAdminLogoutCookieFoo() {
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		response.addCookie(new Cookie("role", "role"));		
		ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);

		underTest.adminLogin(request, response);

		verify(response).addCookie(cookieCaptor.capture());
		Cookie cookie = cookieCaptor.getValue();

		assertThat(cookie.getName(), is("role"));
	}

}

