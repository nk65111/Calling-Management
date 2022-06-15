package com.contact.contact.Repository;

import java.util.List;

import com.contact.contact.Entity.GlobalContact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GlobalContactRepository extends JpaRepository<GlobalContact,Integer> {

      @Query("select g from GlobalContact g where g.name like :key")
      List<GlobalContact> findByName(@Param("key") String name);
      
      @Query("select g from GlobalContact g where g.number like :key")
      List<GlobalContact> findByContact(@Param("key") String number);

     
}
