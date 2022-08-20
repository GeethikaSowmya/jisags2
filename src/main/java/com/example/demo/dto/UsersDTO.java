package com.example.demo.dto;

import java.util.List;
import com.example.demo.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDTO {
	
	
    private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String phone;
		
	private String website;
	
	private List<Address> address;

}
