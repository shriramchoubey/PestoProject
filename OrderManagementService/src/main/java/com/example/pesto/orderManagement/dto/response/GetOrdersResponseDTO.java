package com.example.pesto.orderManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import com.example.pesto.commons.dao.Order;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetOrdersResponseDTO extends BaseResponseDTO {

    List<Order> orders;
}
