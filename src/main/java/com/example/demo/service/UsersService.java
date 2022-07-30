package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersRequestDTO;
import com.example.demo.model.Users;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	ModelMapper mm = new ModelMapper();
	
	public Users addUsersDetails(UsersRequestDTO usersDTO)
	{
		Users users = mm.map(usersDTO, Users.class);
		return usersRepository.save(users);
	}
	
	public List<Users> getAllUsers()
	{
		return usersRepository.findAll();
	}
	
	public Users updateUserDetails(UsersRequestDTO usersDTO) 
	{
		Users users = mm.map(usersDTO, Users.class);
		return usersRepository.save(users);
	}
	
	public Optional<Users> getUserDetails(int id)
	{
		return usersRepository.findById(id);
	}
	
	public void deleteUserDetails(int id) 
	{
	    usersRepository.deleteById(id);
	}

	
	
}
	


