package com.barclays.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.entities.User;
import com.barclays.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/getall")
	public List<User> getAll() {
		return service.getAllUsers();
	}

	@GetMapping("/get")
	public User getUser(Integer uid) {
		return service.getUser(uid);
	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}

}
