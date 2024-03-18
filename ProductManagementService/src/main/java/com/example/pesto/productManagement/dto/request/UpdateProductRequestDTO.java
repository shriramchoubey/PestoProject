package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateProductRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "id should not be empty or null")
    private String id;

    private String name;
    private String description;
    private String image;
}
