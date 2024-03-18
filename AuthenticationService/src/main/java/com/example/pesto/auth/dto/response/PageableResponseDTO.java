package com.example.pesto.auth.dto.response;

import com.example.pesto.commons.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class PageableResponseDTO extends BaseResponseDTO {
    private List<?> data;
    private int totalObjects;
    private int totalPages;
}
