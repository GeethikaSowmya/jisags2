package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	//get
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}
	
	//getbyid
	public Optional<Users> getUser(int id) {
		return usersRepository.findById(id);
	}
	//post
	public Users createUser(Users userData) {
		return usersRepository.save(userData);
	}
	//post
	public Users updateUser(int id,Users userData) {
		return usersRepository.save(userData);
	}
   //delete by id
	public void deleteUser(int id) {
		usersRepository.deleteById(id);
	}
	//delete
	public void deleteUsers() {
		usersRepository.deleteAll();
	}

}
