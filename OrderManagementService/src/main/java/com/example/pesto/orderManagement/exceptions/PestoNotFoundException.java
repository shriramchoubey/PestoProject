package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoNotFoundException extends PestoException {
    public PestoNotFoundException(final Throwable cause) {
        super("Item not found", HttpStatus.NOT_FOUND, cause);
    }

    public PestoNotFoundException() {
        this(null);
    }
}
