package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateProductRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "id should not be empty or null")
    @Size(min = 1, max=100)
    private String id;

    private String name;
    private String description;
    private String image;
}
