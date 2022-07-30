package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Address;

import lombok.ToString;


public class UsersResponseDTO {


    private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String phone;
		
	private String website;
	
	private List<Address> address;

}


