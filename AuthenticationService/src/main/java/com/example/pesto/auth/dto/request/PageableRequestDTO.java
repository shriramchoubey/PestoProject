package com.example.pesto.auth.dto.request;

import com.example.pesto.commons.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageableRequestDTO extends BaseRequestDTO {
    private List<@NotBlank String> filters;

    @NotNull
    private Integer pageSize;

    @NotNull
    private Integer pageNumber;

    private String sortOn;

    public void addFilter(String filter){
        this.filters.add(filter);
    }
}
