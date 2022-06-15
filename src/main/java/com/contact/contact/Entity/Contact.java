package com.contact.contact.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Setter
@Getter
@NoArgsConstructor
public class Contact {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private int contactId;

   private String contactName;
   private String contactPhoneNumber;


   @ManyToOne
   private User user;

}
