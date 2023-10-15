package com.app.crm.data.exceptions;


public class CustomerNotFoundException  extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
    
}
