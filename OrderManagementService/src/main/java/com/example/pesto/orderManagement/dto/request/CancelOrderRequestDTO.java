package com.example.pesto.orderManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOrderRequestDTO extends BaseRequestDTO {
    private String id;
}
