package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;

public class UsersController {

	@Autowired
	UsersController usersController;
	
	@MockBean
	UsersService usersService;
	
	
	@Test
	public void  CreateUsersTest(){
		when(usersService.regForm(any(Users.class))).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
		Users users = new Users();
		users.setName("geethika");
		users.setUsername("sowmya");
		users.setEmail("sowmya.k@gmail.com");
		users.setPhone("4541515415");
		ResponseEntity<Object> responseEntity =  usersController.users(users);
		Assertions.assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testGetAll() {
		when(users.getData()).thenReturn(Arrays.asList(new Users()));
		
		List<Users> responseEntity=usersController.getData();
		assertThat(responseEntity).size().isGreaterThan(0);
		
	}
	
	@Test
	public void testGetId() throws Exception {
		when(usersService.findById(23L)).thenReturn(Optional.ofNullable(new Users()));
		ResponseEntity<Object> responseEntity =  (ResponseEntity<Object>) usersController.getId(23L);
		Assertions.assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
		
	}

	@Test
	public void testUpdate()  {
		when(usersService.updateData(any(Users.class), eq(23L))).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
		Users Users = new Users();
		Users users=new Users();
		users.setId(28L);
		users.setName("Geethika");
		users.setUsername("Sowmya");
		users.setEmail("sowmya.s@gmail.com");
		users.setPhone("6565546464");
		ResponseEntity<?> responseEntity = usersController.updateData(users,23L);
		Assertions.assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
		
	}
	
}
