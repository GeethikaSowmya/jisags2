package com.example.demo.dto;


public class UsersAddressDTO {
	
	private long userId;
	private String name;
	private String username;
	private String email;
	private String state;
	private String city;
	private String postalcode;

public UsersAddressDTO() {
	super();
}
public UsersAddressDTO(long userId, String name, String username, String email, String state, String city, String postalcode) {
	super();
	this.userId = userId;
	this.name = name;
	this.username = username;
	this.email = email;
	this.city = city;
	this.state = state;
	this.postalcode = postalcode;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPostalcode() {
	return postalcode;
}
public void setPostalcode(String postalcode) {
	this.postalcode = postalcode;
}


}

	