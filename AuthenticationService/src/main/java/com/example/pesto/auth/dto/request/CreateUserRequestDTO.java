package com.example.pesto.auth.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import com.example.pesto.commons.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateUserRequestDTO extends BaseRequestDTO {
    @NotBlank(message = "username can't be blank")
    private String username;

    @NotBlank(message = "name can't be blank")
    private String name;

    private String email;

    @NotBlank(message = "User password can't be blank")
    private String password;

    @Pattern(regexp="^(ADMIN|OPS|USER)$",message="this is not valid paymentStatus put either one of ADMIN | OPS | USER")
//    @Enumerated(EnumType.STRING)
    private String role;
}
