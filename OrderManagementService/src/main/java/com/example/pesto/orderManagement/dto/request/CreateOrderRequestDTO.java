package com.example.pesto.orderManagement.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateOrderRequestDTO extends BaseRequestDTO {
    @NotBlank
    @Size(min = 1, max=100)
    private String prodId;

    @NotBlank
    @Size(min = 1, max=100)
    private String address;

    @Pattern(regexp="^(PAID|UNPAID)$",message="this is not valid paymentStatus put either one of PAID or UNPAID")
    private String paymentStatus;

    @NotNull
    @Min(value = 1, message = "quantity should be minimum= 1 and maximum=10")
    @Max(value = 10, message = "quantity should be minimum= 1 and maximum=10")
    private Integer quantity;
}
