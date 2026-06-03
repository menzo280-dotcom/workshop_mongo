package com.enzo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzo.workshopmongo.domain.User;
import com.enzo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
