package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoUnauthorisedOperationException extends PestoException {
    public PestoUnauthorisedOperationException(final Throwable cause) {
        super("User can not perform such operation", HttpStatus.UNAUTHORIZED, cause);
    }

    public PestoUnauthorisedOperationException() {
        this(null);
    }
}