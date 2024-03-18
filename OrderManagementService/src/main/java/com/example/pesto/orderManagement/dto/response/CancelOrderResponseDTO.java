package com.example.pesto.orderManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CancelOrderResponseDTO extends BaseResponseDTO {
    private String message;
    private String id;

}