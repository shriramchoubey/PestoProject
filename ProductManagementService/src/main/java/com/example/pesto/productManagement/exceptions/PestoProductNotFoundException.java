package com.example.pesto.productManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoProductNotFoundException extends PestoException {
    public PestoProductNotFoundException(final Throwable cause) {
        super("No Product found with the product id", HttpStatus.NOT_FOUND, cause);
    }

    public PestoProductNotFoundException() {
        this(null);
    }
}
