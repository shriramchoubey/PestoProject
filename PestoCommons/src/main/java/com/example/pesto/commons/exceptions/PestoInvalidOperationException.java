package com.example.pesto.commons.exceptions;

import org.springframework.http.HttpStatus;

public class PestoInvalidOperationException extends PestoException {
    public PestoInvalidOperationException(final Throwable cause) {
        super("Operation not supported yet", HttpStatus.NOT_FOUND, cause);
    }

    public PestoInvalidOperationException(){
        this(null);
    }
}
