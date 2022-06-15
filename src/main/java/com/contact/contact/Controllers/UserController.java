package com.contact.contact.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.contact.contact.Payloads.ApiResponse;
import com.contact.contact.Payloads.ContactDto;
import com.contact.contact.Payloads.UserDto;
import com.contact.contact.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> creatUserHandler(@Valid @RequestBody UserDto userDto){
      UserDto createdUser= this.userService.createUser(userDto); 
      return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<UserDto> updateUserHandler(@RequestBody UserDto userDto,@PathVariable("uid") Integer uid){
      UserDto updatedUser=this.userService.updateUser(userDto, uid);
      return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/{uid}")
    public ResponseEntity<ApiResponse> deleteUserHandler(@PathVariable("uid") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully",true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUserHandler(){
        List<UserDto> userDtos= this.userService.getAllUsers();
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserDto> getSingleUserHandler(@PathVariable("uid") Integer uid){
      UserDto userDto= this.userService.getUserById(uid);
      return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @GetMapping("/{uid}/contact")
    public ResponseEntity<List<ContactDto>> getAllContact(@PathVariable("uid") Integer uid){
      List<ContactDto> contactDtos= this.userService.getSavedContact(uid);
      return new ResponseEntity<>(contactDtos,HttpStatus.OK);
    }
}
