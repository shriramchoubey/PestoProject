package com.example.pesto.orderManagement.dao;

import com.example.pesto.commons.dao.BaseDAO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDAO extends BaseDAO {
    private String id;
    private String name;
    private String description;
    private String image;
    private Long creationDate;
    private Long modifiedDate;
    private String message;
}
