package com.example.pesto.productManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoUserNotCreatedException extends PestoException {
    public PestoUserNotCreatedException(final Throwable cause) {
        super("Not able to create new User", HttpStatus.BAD_REQUEST, cause);
    }

    public PestoUserNotCreatedException(){
        this(null);
    }
}
