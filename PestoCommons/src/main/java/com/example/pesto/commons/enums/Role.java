package com.example.pesto.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    OPS("OPS"),
    USER("USER");

    @NotBlank(message =  "task status can't be blank") String Role;

}
