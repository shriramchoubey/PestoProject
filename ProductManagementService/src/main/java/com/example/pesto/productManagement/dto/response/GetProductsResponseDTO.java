package com.example.pesto.productManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import com.example.pesto.commons.dao.Product;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetProductsResponseDTO extends BaseResponseDTO {

    List<Product> products = new ArrayList<>();
}
