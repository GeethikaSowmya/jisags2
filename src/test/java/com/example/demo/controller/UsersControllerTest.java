package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.UsersRequestDTO;
import com.example.demo.dto.UsersResponseDTO;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;


@SpringBootTest
public class UsersControllerTest {
	@InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;

    @Test
    public void createUsersTest(){
        Mockito.when(usersService.saveUsers(mockusersRequestDTO())).thenReturn(usersResponseDTOMock());
        ResponseEntity<UsersResponseDTO> usersResponse =   usersController.createUsers(mockusersRequestDTO());
        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.CREATED);
    }


    @Test
    public void createUsersTestForNegative(){
        Mockito.when(usersService.addUsersDetails(null)).thenReturn(usersResponseDTOMock());
        ResponseEntity<UsersResponseDTO> usersResponse = usersController.createusers(mockusersRequestDTO());
        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.BAD_REQUEST);
    }
    
    @Test
    public void getAllUsersTest(){
        Mockito.when(usersService.getAllUsers(toString())).thenReturn(usersResponseDTOMock());
        ResponseEntity<UsersResponseDTO> usersResponse = usersController.getAllUsers(mockusersRequestDTO());
        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.OK);
    }


    @Test
    public void getUsersForNegative(){
        Mockito.when(usersService.getAllUsers(null)).thenReturn(usersResponseDTOMock());
        ResponseEntity<UsersResponseDTO> usersResponse = usersController.getAllUsers(toString());
        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.NOT_FOUND);
    }
    
    @Test
    public void updateUserDetailsTest(){
        Mockito.when(usersService.updateUserDetails(mockusersRequestDTO())).thenReturn(usersResponseDTOMock());
        Users usersResponse =   usersController.updateUserDetails(mockusersRequestDTO());
        Assertions.assertEquals(usersResponse.getStatusCode() ,HttpStatus.OK);
    }


    @Test
    public void updateUserDetailsForNegative(){
        Mockito.when(usersService.updateUserDetails(null)).thenReturn(mockusersRequestDTO());
        ResponseEntity<UsersDTO> usersResponse =   userController.updateusers(mockusersRequestDTO());
        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.BAD_REQUEST);
    }

//    @Test
//    public void deleteusersTest(){
//        Mockito.when(usersService.deleteUserDetails(usersDeleteDTOMock())).thenReturn(RECORD_DELETED);
//        ResponseEntity<String> usersResponse = usersController.deleteusers(usersDeleteDTOMock());
//        Assertions.assertEquals(usersResponse.getStatusCode() ,HttpStatus.OK);
//    }
//
//
//    @Test
//    public void deleteusersForNegative(){
//        Mockito.when(usersService.deleteUserDetails(null)).thenReturn(NOT_FOUND);
//        ResponseEntity<String> usersResponse =   usersController.deleteusers(usersDeleteDTOMock());
//        Assertions.assertEquals(usersResponse.getStatusCode() , HttpStatus.NOT_FOUND);
//    }
    private UsersRequestDTO mockusersRequestDTO(){
    	UsersRequestDTO usersRequestDTO = new UsersRequestDTO();
    	usersRequestDTO.setId(109);
    	usersRequestDTO.setName("Mock Name");
    	usersRequestDTO.setUsername("Mock User Name");
    	usersRequestDTO.setPhone("6545446");
    	usersRequestDTO.setEmail("test@gmail.com");

    	
        return usersRequestDTO;
    }

    private Users usersResponseDTOMock(){
    	Users usersResponseDTO = new UsersResponseDTO();
    	usersResponseDTO.setId(109);
    	usersResponseDTO.setName("Mock Name");
    	usersResponseDTO.setUsername("Mock User Name");
    	usersResponseDTO.setPhone("6545446");
    	usersResponseDTO.setEmail("test@gmail.com");
        return usersResponseDTO;
    }

//    private UsersDeleteDTO usersDeleteDTOMock(){
//    	UsersDeleteDTO usersDeleteDTO = new UsersDeleteDTO();
//        usersDeleteDTO.setId("101");
//        usersDeleteDTO.setModifiedBy("mock");
//        return usersDeleteDTO;
//    }


    private List<UsersResponseDTO> listOfUsersMock(){
        List<UsersResponseDTO> listOfusers = new ArrayList<>();
        UsersResponseDTO users = new UsersResponseDTO();
        users.setid(109);
        users.setname("Mock Name");
    	users.setUsername("Mock User Name");
    	users.setPhone("6545446");
    	users.setEmail("test@gmail.com");

        UsersResponseDTO users1 = new UsersResponseDTO();
        users1.setId(109);
    	users1.setName("Mock Name");
    	users1.setUsername("Mock User Name");
    	users1.setPhone("6545446");
    	users1.setEmail("test@gmail.com");


    	UsersResponseDTO users2 = new UsersResponseDTO();
        users2.setId(109);
    	users2.setName("Mock Name");
    	users2.setUsername("Mock User Name");
    	users2.setPhone("6545446");
    	users2.setEmail("test@gmail.com");

    	listOfusers.add(users);
    	listOfusers.add(users1);
    	listOfusers.add(users2);
        return listOfusers;
    }

    

}

