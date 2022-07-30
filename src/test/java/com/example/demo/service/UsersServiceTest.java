package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dto.UsersRequestDTO;
import com.example.demo.model.Address;
import com.example.demo.model.Users;


	    
@SpringBootTest
public class UsersServiceTest {
    
    @Mock
    private UsersService usersService;
    
    
    @Test
    public void addUsersDetailsTest()
    {
        Address address = new Address(1,"gandhi nagar","raju street","vsp","65789");
        
        List<Address> usersAddress = new ArrayList<>();
        usersAddress.add(address);
        UsersRequestDTO usersDTO = new UsersRequestDTO(1,"Ram","raju","ram@gmail.com","561616416","www.raju.com", usersAddress);
        usersService.addUsersDetails(usersDTO); 
        verify(usersService, times(1)).addUsersDetails(usersDTO);
    }
        
    @Test
    public void getAllUsersTest()
    {
        
        Address address1 = new Address(1,"test name","test1","vsp","15111");
        Address address2 = new Address(2,"test name","test1","vsp","15111");
        Address address3 = new Address(3,"test","test1","vsp","321544");
        
        List<Address> users1Address = new ArrayList<>();
        users1Address.add(address3);
        users1Address.add(address1);
        Users users1 = new Users(1,"sruthi","sagar","sagar@gmail.com","8234590922","www.sagar.com", users1Address);
        
        List<Address> users2Address = new ArrayList<>();
        users2Address.add(address2);
        
        Users users2 = new Users(2,"megana","sri","megana@gmail.com","9087612354","www.divya.com",users2Address);
        
        Users users3 = new Users(3,"surya","raj","surya@gmail.com","9087612354","www.laxmi.com",null);
        List<Users> list = new ArrayList<Users>();
        list.add(users1);
        list.add(users2);
        list.add(users3);
        when(usersService.getAllUsers()).thenReturn(list);
        List<Users> usersList = usersService.getAllUsers();
        assertEquals(3, usersList.size());
        
        verify(usersService, times(1)).getAllUsers();
    }
    
    @Test
    public void updateUsersDetailsTest()
    {
        Address address=new Address(1,"gandhi nagar","kancharapalem","vsp","51515");
        
        List<Address> usersAddress=new ArrayList<>();
        usersAddress.add(address);
        
        
        UsersRequestDTO usersDTO = new UsersRequestDTO(1,"surya","raj","surya@gmail.com","5152151412415","raju@.com", usersAddress);
        usersService.updateUserDetails(usersDTO);
        verify(usersService, times(1)).updateUserDetails(usersDTO);
    }
    
    @Test
    public void getUserDetailsTest()
    {
        
        Address address1 = new Address(1,"bhanu street","garividi","vzm","65789");
        
        List<Address> users1Address = new ArrayList<>();
        users1Address.add(address1);
        
        Optional<Users> users1 = Optional.of(new Users(1,"Ramesh","raj","ramesh@gmail.com","56326666","www.raj.com", users1Address));
        when(usersService.getUserDetails(1)).thenReturn(users1);
        
        Optional<Users> users=usersService.getUserDetails(1);
        assertEquals("surya", users.get().getName());
        assertEquals("5151541515", users.get().getPhone());
        assertEquals(1, users.get().getId());
    }
    
}