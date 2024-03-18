package com.example.pesto.productManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UpdateProductResponseDTO extends BaseResponseDTO {
    private String message;

}