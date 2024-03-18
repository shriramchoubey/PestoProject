package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoNoUserException extends PestoException {
    public PestoNoUserException(final Throwable cause) {
        super("No User Exception", HttpStatus.BAD_REQUEST, cause);
    }

    public PestoNoUserException(){
        this(null);
    }
}
