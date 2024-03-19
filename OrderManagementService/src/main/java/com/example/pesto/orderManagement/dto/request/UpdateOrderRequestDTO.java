package com.example.pesto.orderManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import com.example.pesto.commons.enums.OrderStatus;
import com.example.pesto.commons.enums.PaymentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateOrderRequestDTO extends BaseRequestDTO {

    @NotBlank
    @Size(min = 1, max=100)
    String id;

    @Pattern(regexp="^(ORDERED|DELIVERED|CANCELLED)$",message="this is not valid paymentStatus put either one of ORDERED | DELIVERED | CANCELLED")
    String status;

    @Pattern(regexp="^(PAID|UNPAID)$",message="this is not valid paymentStatus put either one of PAID or UNPAID")
    String paymentStatus;

}
