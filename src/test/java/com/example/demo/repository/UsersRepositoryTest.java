package com.example.demo.repository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;

@SpringBootTest
public class UsersRepositoryTest {

		@InjectMocks
		private UsersService usersService;

		@Mock
		private UsersRepository usersRepository;
	
		
		
		@Test
		public void testGetName() {
			
			Users users=new Users();
			users.setId(28L);
			users.setName("Geethika");
			users.setUsername("Sowmya");
			users.setEmail("sowmya.s@gmail.com");
			users.setPhone("6565546464");
			
					when(usersRepository.findByid(long())).thenReturn(users);
		}
	}

