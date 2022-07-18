package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsersAddressDTO;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersservice;
	
	@GetMapping("/users")
	public List<UsersAddressDTO> getUsers() {
		return usersservice.getUsers();
	}
	@GetMapping("/user/{id}")
	public Optional<UsersAddressDTO> getUser(@PathVariable long id) {
		return usersservice.getUser(id);
	}
																																						
	@PostMapping("/user")
	public UsersAddressDTO createUsers(@RequestBody Users users) {
		return usersservice.createUser(users);
	}
	
	@PutMapping("/user/{id}")
	public UsersAddressDTO updateUsers(@PathVariable long id, @RequestBody Users users) {
		return usersservice.updateUser(id,users);
	}	
	
	@DeleteMapping("/user/{id}")
	public String deleteUsers(@PathVariable long id) {
		usersservice.deleteUsers(id);
		return("Deleted ");
	}	
	
	@DeleteMapping("/users")
	public String deleteUsers() {
		usersservice.deleteUsers();
		return("All users deleted");
	}	
}
