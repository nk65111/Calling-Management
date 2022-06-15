package com.contact.contact.Controllers;

import java.util.List;

import com.contact.contact.Payloads.GlobalContactDto;
import com.contact.contact.Service.GlobalUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private GlobalUserService globalUserService;
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<GlobalContactDto>> getAllContactByName(@PathVariable("name") String name){
      List<GlobalContactDto> globalContactDtos=  this.globalUserService.findByName(name);
      return new ResponseEntity<>(globalContactDtos,HttpStatus.OK);
    }

    @GetMapping("/contact/{number}")
    public ResponseEntity<List<GlobalContactDto>> getAllContactByContact(@PathVariable("number") String number){
        List<GlobalContactDto> globalContactDtos=  this.globalUserService.findByContact(number);
        return new ResponseEntity<>(globalContactDtos,HttpStatus.OK);
      }
}
