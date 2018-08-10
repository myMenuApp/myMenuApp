package com.HandCrest.myMenuApp;

import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long>{
	
	Menu findByMenuName(String menuName);

}
