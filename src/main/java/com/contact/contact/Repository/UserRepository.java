package com.contact.contact.Repository;

import com.contact.contact.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}
