package com.example.pesto.commons.exceptions;

import org.springframework.http.HttpStatus;

public class PestoAmazonException extends PestoException {
    public PestoAmazonException(final Throwable cause) {
        super("Amazon Service error", HttpStatus.INTERNAL_SERVER_ERROR, cause);
    }

    public PestoAmazonException(){
        this(null);
    }
}
