package com.contact.contact.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.contact.contact.Entity.Contact;
import com.contact.contact.Entity.GlobalContact;
import com.contact.contact.Entity.User;
import com.contact.contact.Exception.ResourseNotFound;
import com.contact.contact.Payloads.ContactDto;
import com.contact.contact.Repository.ContanctRepository;
import com.contact.contact.Repository.GlobalContactRepository;
import com.contact.contact.Repository.UserRepository;
import com.contact.contact.Service.ContactService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactImpl  implements ContactService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContanctRepository contanctRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private GlobalContactRepository globalContactRepository;

    @Override
    public ContactDto createContact(ContactDto contactDto, Integer userId) {
       User user= this.userRepository.findById(userId).orElseThrow(()->new ResourseNotFound("User", "User_ID", userId));

       Contact contact= this.modelMapper.map(contactDto, Contact.class);
       contact.setUser(user);

      GlobalContact globalContact=new GlobalContact();
      globalContact.setName(contact.getContactName());
      globalContact.setNumber(contact.getContactPhoneNumber());
      globalContact.setSpam(false);
      this.globalContactRepository.save(globalContact);

      Contact savedContact=  this.contanctRepository.save(contact);
      return this.modelMapper.map(savedContact, ContactDto.class);

    }

    @Override
    public void deleteContact(Integer contactId) {
        Contact contact= this.contanctRepository.findById(contactId).orElseThrow(()->new ResourseNotFound("Contact", "Contact_ID", contactId));
        this.contanctRepository.delete(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
       List<Contact> contacts=this.contanctRepository.findAll();
       List<ContactDto> contactDtos=new ArrayList<>();
       for(Contact contact:contacts){
           contactDtos.add(this.modelMapper.map(contact, ContactDto.class));
       }
       return contactDtos;
    }

    @Override
    public ContactDto getSingleContact(Integer contactId) {
        Contact contact= this.contanctRepository.findById(contactId).orElseThrow(()->new ResourseNotFound("Contact", "Contact_ID", contactId));
        return this.modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public ContactDto updateContact(ContactDto contactDto, Integer contactId) {
        Contact contact= this.contanctRepository.findById(contactId).orElseThrow(()->new ResourseNotFound("Contact", "Contact_ID", contactId));
        contact.setContactName(contactDto.getContactName());
        contact.setContactPhoneNumber(contactDto.getContactPhoneNumber());
        Contact savedContact= this.contanctRepository.save(contact);
        return this.modelMapper.map(savedContact, ContactDto.class);

    }
    
}
