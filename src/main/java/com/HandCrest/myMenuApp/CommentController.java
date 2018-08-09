package com.HandCrest.myMenuApp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	//Add comment to item page
	@RequestMapping(value = "/menus/{menuId}/items/{itemId}", method = RequestMethod.POST)
	public Collection<Comment> addCommment(@PathVariable(name = "menuId") Long menuId,
			@PathVariable(name = "itemId") Long itemId,
			@RequestParam(value = "creator") String creator, 
			@RequestParam(value = "comment") String comment)			{
	commentRepo.save(new Comment(creator, comment,itemRepo.findOne(itemId)));
	return itemRepo.findOne(itemId).getComments();
	
	}
}
