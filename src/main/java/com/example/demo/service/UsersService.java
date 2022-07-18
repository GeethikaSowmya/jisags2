package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersAddressDTO;
import com.example.demo.model.Users;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UsersRepository;



@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersrepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<UsersAddressDTO> getUsers() {
		return usersrepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	public Optional<UsersAddressDTO> getUser(long id) {
		return usersrepository.findById(id)
				.stream()
				.map(this::convertEntityToDto)
				.findFirst();
	}
			
	public UsersAddressDTO createUser(Users users) {
		usersrepository.save(users);
		return convertEntityToDto(users);
	}
	
	public UsersAddressDTO updateUser(long id,Users users) {
		usersrepository.findById(id).orElseThrow();
		usersrepository.save(users);
		return convertEntityToDto(users);
	}

	public void deleteUsers(long id) {
		usersrepository.findById(id).orElseThrow();
		usersrepository.deleteById(id);
	}
	
	public void deleteUsers() {
		usersrepository.deleteAll();
	}
	
	public UsersAddressDTO convertEntityToDto(Users users) {
		UsersAddressDTO usersAddressDTO = new UsersAddressDTO();
		usersAddressDTO.setUserId(users.getId());
		usersAddressDTO.setName(users.getName());
		usersAddressDTO.setUsername(users.getUsername());
		usersAddressDTO.setEmail(users.getEmail());
		usersAddressDTO.setCity(users.getAddress().getCity());
		usersAddressDTO.setPostalcode(users.getAddress().getPostalcode());
		return usersAddressDTO;
	}
}

		
	


