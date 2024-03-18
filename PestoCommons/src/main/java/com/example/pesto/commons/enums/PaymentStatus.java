package com.example.pesto.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PAID("PAID"),
    UNPAID("UNPAID");
    @NotBlank(message =  "payment status can't be blank") String PaymentStatus;
}
