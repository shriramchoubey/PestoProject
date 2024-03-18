package com.example.pesto.orderManagement.exceptions;

import com.example.pesto.commons.exceptions.PestoException;
import org.springframework.http.HttpStatus;

public class PestoPayslipException extends PestoException {
    public PestoPayslipException(final Throwable cause){
        super("Invalid Payslip", HttpStatus.BAD_REQUEST,cause);
    }
    public PestoPayslipException(){this(null);}
}
