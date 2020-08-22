package com.app.exercise.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exercise.model.bean.User;
import com.app.exercise.model.generic.BaseResult;
import com.app.exercise.model.generic.UserToken;
import com.app.exercise.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	//Para este el body del request solo necesita email y password
	@GetMapping(value = "/userAuth",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserToken> login(@RequestBody UserToken user) {
		return service.loginAuth(user);
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> retrieveUsers() {
		return service.retriveUsers();
	}

	@PostMapping(value = "/users/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User User) {
		return service.addUser(User);
	}
	
	@PutMapping(value = "/users/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping(value = "/users/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> deleteUser(@PathVariable UUID id) {
		return service.deleteUser(id);
	}
	
}
