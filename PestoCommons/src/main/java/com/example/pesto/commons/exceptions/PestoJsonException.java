package com.example.pesto.commons.exceptions;

import org.springframework.http.HttpStatus;

public class PestoJsonException extends PestoException {
    public PestoJsonException(final Throwable cause) {
        super("Json not in proper format", HttpStatus.NOT_ACCEPTABLE, cause);
    }

    public PestoJsonException(){
        this(null);
    }
}
