package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.UsersAddressDTO;
import com.example.demo.model.Address;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;


@SpringBootTest
public class UsersServiceTest {

@Autowired
private UsersService usersService;


@MockBean
private UsersRepository usersRepository;

@Test
public void createUserTest()
{
    Address address = new Address("AP","Vizag","2334");

    List<Address> usersAddress = new ArrayList<>();
    usersAddress.add(address);

    UsersAddressDTO usersAddressDTO = new UsersAddressDTO("Geethika","sowmya","geethika@gmail.com", "AP","Vizag", "566555", usersAddress);
    usersService.save(usersAddressDTO); 
    verify(usersService, times(1)).createUser(usersAddress);
}
@Test
public void getUserDetailsTest()
{
    
    Address address1 = new Address("AP","Vizag","2334");
    
    List<Address> users1Address = new ArrayList<>();
    users1Address.add(address1);
    
    Optional<Users> users1 = Optional.of(new UsersAddressDTO("Geethika","sowmya","geethika@gmail.com", "AP","Vizag", "566555", users1Address);
    when(usersService.getUser(1)).thenReturn(users1);
    
    Optional<UsersAddressDTO> users=usersService.getUser(1);
    assertEquals("Geethika", users.get().getName());
    assertEquals("2364565688", users.get().getPhone());
    assertEquals(1, users.get().getUserId());
}
@Test
public void updateUsersDetailsTest()
{
    Address address=new Address("AP","Vizag","2334");
    
    List<Address> usersAddress=new ArrayList<>();
    usersAddress.add(address);
    
    UsersAddressDTO usersAddressDTO = new UsersAddressDTO(1,"Geethika","sowmya","geethika@gmail.com", "AP","Vizag", "566555", users1Address);
    usersService.updateUsers(usersAddressDTO);
    verify(usersService, times(1)).updateUsers(usersAddressDTO);
}



}
