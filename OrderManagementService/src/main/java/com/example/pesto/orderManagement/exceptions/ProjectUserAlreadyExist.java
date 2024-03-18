package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class ProjectUserAlreadyExist extends PestoException {
    public ProjectUserAlreadyExist(final Throwable cause) {
        super("User Already Exist", HttpStatus.BAD_REQUEST, cause);
    }

    public ProjectUserAlreadyExist(){
        this(null);
    }
}
