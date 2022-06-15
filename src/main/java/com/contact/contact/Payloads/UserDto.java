package com.contact.contact.Payloads;



import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
  
    private int id;
    private String username;
    private String email;
    private String password;

    @Size(min=10,max=13,message="phone number invalid")
    private String phoneNumber;
}
