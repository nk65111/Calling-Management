package com.contact.contact.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.contact.contact.Entity.GlobalContact;
import com.contact.contact.Exception.ResourseNotFound;
import com.contact.contact.Payloads.GlobalContactDto;
import com.contact.contact.Repository.GlobalContactRepository;
import com.contact.contact.Service.GlobalUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Globalmpl implements GlobalUserService {

    @Autowired
    private GlobalContactRepository globalContactRepository;

    @Autowired
    private ModelMapper modalMapper;

    @Override
    public List<GlobalContactDto> findByContact(String number) {
        List<GlobalContact> globalContacts=this.globalContactRepository.findByContact("%"+number+"%");
        List<GlobalContactDto> globalContactDtos=new ArrayList<>();

        for(GlobalContact globalContact:globalContacts){
            globalContactDtos.add(this.modalMapper.map(globalContact, GlobalContactDto.class));
        }
         return globalContactDtos;
    }

    @Override
    public List<GlobalContactDto> findByName(String name) {
        List<GlobalContact> globalContacts=this.globalContactRepository.findByName("%"+name+"%");
        List<GlobalContactDto> globalContactDtos=new ArrayList<>();

        for(GlobalContact globalContact:globalContacts){
            globalContactDtos.add(this.modalMapper.map(globalContact, GlobalContactDto.class));
        }
         return globalContactDtos;
    }

    @Override
    public void setSpam(Integer gid) {
      GlobalContact globalContact= this.globalContactRepository.findById(gid).orElseThrow(()->new ResourseNotFound("GlobalContact", "id", gid));
     
      globalContact.setSpam(globalContact.isSpam()==true?false:true);
      this.globalContactRepository.save(globalContact);
    }

    @Override
    public List<GlobalContactDto> getAllContact() {
       List<GlobalContact> globalContacts= this.globalContactRepository.findAll();
        List<GlobalContactDto> globalContactDtos=new ArrayList<>();

        for(GlobalContact globalContact:globalContacts){
            globalContactDtos.add(this.modalMapper.map(globalContact, GlobalContactDto.class));
        }
        return globalContactDtos;
    }

    
    
}
