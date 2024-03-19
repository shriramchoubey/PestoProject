package com.example.pesto.productManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteProductRequestDTO extends BaseRequestDTO {
    @NotBlank
    @Size(min = 1, max=100)
    private String id;
}
