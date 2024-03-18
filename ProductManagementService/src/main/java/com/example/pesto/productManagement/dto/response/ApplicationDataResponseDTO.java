package com.example.pesto.productManagement.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data@Builder
@EqualsAndHashCode(callSuper = true)
public class ApplicationDataResponseDTO extends BaseResponseDTO {
    private String data;
    private String bucket;
    private String path;
}
