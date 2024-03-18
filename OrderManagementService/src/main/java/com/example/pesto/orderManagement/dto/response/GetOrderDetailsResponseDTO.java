package com.example.pesto.orderManagement.dto.response;

import com.example.pesto.commons.dao.Order;
import com.example.pesto.commons.dto.BaseResponseDTO;
import com.example.pesto.commons.enums.OrderStatus;
import com.example.pesto.commons.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetOrderDetailsResponseDTO extends BaseResponseDTO {
    private String id;
    private String prodId;


    private String status;
    private String address;


    private String paymentStatus;

    private Integer quantity;
    private Long creationDate;
    private Long modifiedDate;
}
