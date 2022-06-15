package com.contact.contact.Controllers;

import com.contact.contact.Payloads.ApiResponse;
import com.contact.contact.Service.GlobalUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spam")
public class SetSpam {
    
    @Autowired
    private GlobalUserService globalUserService;

    @PutMapping("/{gid}")
    public ResponseEntity<ApiResponse> setContactSpam(@PathVariable("gid") Integer gid){
        this.globalUserService.setSpam(gid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("set spam successfully", true), HttpStatus.OK);
    }
}
