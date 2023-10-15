
package com.app.crm.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
@Entity
@Table(name="customer")
public class Customer {
    // id col
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    // first name col
    @Column
    String firstName;
    
    // last name col
    @Column
    String lastName;
    
    // address col
    @Column
    String address;
    
    // city col
    @Column
    String city;
    
    // state col
    @Column
    String state;
    
    // email col
    @Column
    String email;
    
    // phone num col
    @Column
    String phoneNumber;
}
