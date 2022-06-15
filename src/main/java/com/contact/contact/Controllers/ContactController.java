package com.contact.contact.Controllers;

import java.util.List;

import com.contact.contact.Payloads.ApiResponse;
import com.contact.contact.Payloads.ContactDto;
import com.contact.contact.Service.ContactService;

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
@RequestMapping("/api/contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @PostMapping("/user/{uid}")
    public ResponseEntity<ContactDto> createContacHandler(@RequestBody ContactDto contactDto,@PathVariable("uid") Integer uid){
       ContactDto savedContact= this.contactService.createContact(contactDto, uid);
       return new ResponseEntity<ContactDto>(savedContact, HttpStatus.CREATED);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDto> updateContactHandler(@RequestBody ContactDto contactDto,@PathVariable("contactId") Integer contactId){
       ContactDto updatedContactDto= this.contactService.updateContact(contactDto, contactId);
       return new ResponseEntity<ContactDto>(updatedContactDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<ApiResponse> deletContactHandler(@PathVariable("contactId") Integer contactId){
        this.contactService.deleteContact(contactId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("contact is deleted", true) , HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> getAllContactHandler(){
      List<ContactDto> contactDtos=  this.contactService.getAllContacts();
      return new ResponseEntity<>(contactDtos,HttpStatus.OK);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDto> getSingleContact(@PathVariable("contactId") Integer contactId){
       ContactDto contactDto= this.contactService.getSingleContact(contactId);
       return ResponseEntity.ok(contactDto);
    }

}
