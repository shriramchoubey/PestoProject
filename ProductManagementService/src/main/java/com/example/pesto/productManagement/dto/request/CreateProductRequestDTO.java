package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateProductRequestDTO extends BaseRequestDTO {
    @NotBlank
    @Size(min = 1, max=100)
    private String name;
    @NotBlank
    @Size(min = 1, max=500)
    private String description;
    @NotBlank
    @Size(min = 1, max=100)
    private String image;
}
