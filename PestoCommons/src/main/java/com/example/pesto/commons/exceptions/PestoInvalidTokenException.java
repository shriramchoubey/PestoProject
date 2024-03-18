package com.example.pesto.commons.exceptions;

import org.springframework.http.HttpStatus;

public class PestoInvalidTokenException extends PestoException {
    public PestoInvalidTokenException(final Throwable cause) {
        super("Invalid Token", HttpStatus.NOT_FOUND, cause);
    }

    public PestoInvalidTokenException(){
        this(null);
    }
}
