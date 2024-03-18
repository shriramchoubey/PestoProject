package com.example.pesto.orderManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import com.example.pesto.commons.enums.PaymentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateOrderRequestDTO extends BaseRequestDTO {
    private String prodId;
    private String address;

    @Enumerated(EnumType.STRING) // validate paid or unpaid
    private PaymentStatus paymentStatus;

    private Integer quantity;
}
