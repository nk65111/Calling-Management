package com.contact.contact.Service;

import java.util.List;

import com.contact.contact.Payloads.ContactDto;
import com.contact.contact.Payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    
    UserDto updateUser(UserDto userDto,Integer userid);

    void deleteUser(Integer userid);

    List<UserDto> getAllUsers();

    UserDto getUserById(Integer userid);

    List<ContactDto> getSavedContact(Integer userid);
}
