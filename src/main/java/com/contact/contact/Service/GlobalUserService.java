package com.contact.contact.Service;

import java.util.List;

import com.contact.contact.Payloads.GlobalContactDto;

public interface GlobalUserService {
    
    List<GlobalContactDto> findByName(String name);

    List<GlobalContactDto> findByContact(String number);

    void setSpam(Integer gid);

    List<GlobalContactDto> getAllContact();
}
