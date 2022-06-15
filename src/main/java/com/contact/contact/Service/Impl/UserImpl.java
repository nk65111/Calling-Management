package com.contact.contact.Service.Impl;

import java.util.ArrayList;
import java.util.List;


import com.contact.contact.Entity.Contact;
import com.contact.contact.Entity.GlobalContact;
import com.contact.contact.Entity.User;
import com.contact.contact.Exception.ResourseNotFound;
import com.contact.contact.Payloads.ContactDto;
import com.contact.contact.Payloads.UserDto;
import com.contact.contact.Repository.GlobalContactRepository;
import com.contact.contact.Repository.UserRepository;
import com.contact.contact.Service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GlobalContactRepository globalContactRepository;

    @Override
    public UserDto createUser(UserDto userDto) { 
      User user=  this.modelMapper.map(userDto, User.class);
      User savedUser= this.userRepository.save(user);

      GlobalContact globalContact=new GlobalContact();
      globalContact.setName(userDto.getUsername());
      globalContact.setNumber(userDto.getPhoneNumber());
      globalContact.setSpam(false);
      this.globalContactRepository.save(globalContact);

      return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Integer userid) {
       User user= this.userRepository.findById(userid).orElseThrow(()->new ResourseNotFound("User", "User_Id", userid));
       this.userRepository.delete(user);
        
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=this.userRepository.findAll();

        List<UserDto> userDtos=new ArrayList<>();
        for(User user:users){
            userDtos.add(this.modelMapper.map(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(Integer userid) {
        User user= this.userRepository.findById(userid).orElseThrow(()->new ResourseNotFound("User", "User_Id", userid));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userid) {
        User user= this.userRepository.findById(userid).orElseThrow(()->new ResourseNotFound("User", "User_Id", userid));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
       User updateUser= this.userRepository.save(user);

        
       UserDto updatUserDto= this.modelMapper.map(updateUser, UserDto.class);

       return updatUserDto;

    }

    @Override
    public List<ContactDto> getSavedContact(Integer userid) {
        User user= this.userRepository.findById(userid).orElseThrow(()->new ResourseNotFound("User", "User_Id", userid));
        List<Contact> contacts=user.getContacts();
        List<ContactDto> contactDtos=new ArrayList<>();
        for(Contact contact:contacts){
            contactDtos.add(this.modelMapper.map(contact, ContactDto.class));
        }
        return contactDtos;
    }

    
    
}
