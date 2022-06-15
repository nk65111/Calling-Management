package com.contact.contact.Payloads;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDto  {
  
    private int contactId;
    private String contactName;

    @Size(min=10,max=13,message="number is invalid")
    private String contactPhoneNumber;
    
    private UserDto user;
}
