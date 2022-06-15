package com.contact.contact.Controllers;

import java.util.List;

import com.contact.contact.Payloads.GlobalContactDto;
import com.contact.contact.Service.GlobalUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/global")
public class AllGlobalDataController {
    
    @Autowired
    private GlobalUserService globalUserService;

    @GetMapping("/")
    public ResponseEntity<List<GlobalContactDto>> getAllContact(){
       List<GlobalContactDto> globalContactDtos= this.globalUserService.getAllContact();
       return new ResponseEntity<>(globalContactDtos,HttpStatus.OK);
    }
    
}
