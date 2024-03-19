package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoOrderNotFoundException extends PestoException {
    public PestoOrderNotFoundException(final Throwable cause) {
        super("No order found with the order Id", HttpStatus.NOT_FOUND, cause);
    }

    public PestoOrderNotFoundException() {
        this(null);
    }
}
