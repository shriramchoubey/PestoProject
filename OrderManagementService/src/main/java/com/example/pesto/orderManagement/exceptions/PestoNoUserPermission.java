package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoNoUserPermission extends PestoException {
    public PestoNoUserPermission(Throwable casue){
        super("User doesn't have permission ", HttpStatus.BAD_REQUEST,casue);
    }
    public PestoNoUserPermission(){this(null);}
}
