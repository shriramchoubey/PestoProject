package com.example.pesto.orderManagement.dto.response;


import com.example.pesto.commons.dto.BaseResponseDTO;

import com.example.pesto.orderManagement.dao.ProductDAO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetOrderDetailsResponseDTO extends BaseResponseDTO {
    private String id;
    private ProductDAO product;


    private String status;
    private String address;


    private String paymentStatus;

    private Integer quantity;
    private Long creationDate;
    private Long modifiedDate;
}
