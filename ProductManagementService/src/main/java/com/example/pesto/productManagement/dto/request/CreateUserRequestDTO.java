package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import com.example.pesto.commons.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotBlank;

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
    private Role role;
}
