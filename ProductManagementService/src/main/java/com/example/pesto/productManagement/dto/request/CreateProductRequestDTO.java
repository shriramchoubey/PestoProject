package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateProductRequestDTO extends BaseRequestDTO {
    private String name;
    private String description;
    private String image;
}
