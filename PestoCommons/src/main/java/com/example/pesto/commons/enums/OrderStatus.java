package com.example.pesto.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    ORDERED("ORDERED"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    @NotBlank(message =  "order status can't be blank") String OrderStatus;
}

