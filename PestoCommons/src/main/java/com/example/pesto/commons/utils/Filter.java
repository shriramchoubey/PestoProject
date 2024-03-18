package com.example.pesto.commons.utils;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Filter {
    private String field;
    private String operator;
    private String value;
    private List<String> values;

    public Filter(String filter){
        String[] filterList = filter.split(" ");
        this.field = filterList[0];
        this.operator = filterList[1];
        if(this.operator.equals("IN")){
            this.values = Arrays.asList(filterList[2].split("~"));
        }else{
            this.value = filterList[2];
        }
    }
}
