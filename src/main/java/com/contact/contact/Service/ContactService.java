package com.contact.contact.Service;

import java.util.List;
import com.contact.contact.Payloads.ContactDto;

public interface ContactService {
    
    ContactDto createContact(ContactDto contactDto,Integer userId);

    ContactDto updateContact(ContactDto contactDto,Integer contactId);

    void deleteContact(Integer contactId);

    List<ContactDto> getAllContacts();

    ContactDto getSingleContact(Integer contactId);
}
