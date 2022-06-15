package com.contact.contact.Repository;

import com.contact.contact.Entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContanctRepository extends JpaRepository<Contact,Integer> {
    
}
