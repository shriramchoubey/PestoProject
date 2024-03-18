package com.example.pesto.productManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ViewProductDetailsResponsDTO extends BaseResponseDTO {
    private String id;
    private String name;
    private String description;
    private String image;
    private String createdBy;
    private String lastUpdatedBy;
    private Long creationDate;
    private Long modifiedDate;

    private String message;
}

