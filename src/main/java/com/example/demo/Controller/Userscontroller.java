package com.example.demo.Controller;


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
import com.example.demo.Service.UsersService;
import com.example.demo.model.Users;

@RestController
public class Userscontroller {
	
	@Autowired
	private UsersService usersservice;
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersservice.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<Users> getUser(@PathVariable int id) {
		return usersservice.getUser(id);
	}
	
	@PostMapping("/users/add")
	public Users createUser(@RequestBody Users userData) {
		return usersservice.createUser(userData);
	}
	
	@PutMapping("/users/put/{id}")
	public Users updateUser(@PathVariable int id, @RequestBody Users userData) {
		return usersservice.updateUser(id,userData);
	}	
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		usersservice.deleteUser(id);
		return("Deleted");
	}	
	
	@DeleteMapping("/users")
	public String deleteUsers() {
		usersservice.deleteUsers();
		return("All users deleted");
	}	
}
