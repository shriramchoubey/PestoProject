package com.example.pesto.commons.utils;

import com.example.pesto.commons.exceptions.PestoInvalidOperationException;
import lombok.val;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder<T> {

    public Specification<T> generateSpecs(List<String> filters){
        List<Filter> finalFilter = new ArrayList<>();
        for(val filter: filters){
            val tempFilter = new Filter(filter);
            finalFilter.add(tempFilter);
        }
        return createFinalSpecifications(finalFilter);
    }

    public Specification<T> getDistinctSpecification(String column){
        return (root, query, criteriaBuilder) ->
                (Predicate) criteriaBuilder.createQuery(root.get(column).getJavaType()).distinct(true);
    }

    private Specification<T> createFinalSpecifications(List<Filter> filters) {
        Specification<T> specification = null;
        for(val filter: filters){
            if(specification == null){
                specification = Specification.where(
                        createSpecification(filter)
                );
            }else{
                specification = specification
                        .and(createSpecification(filter));
            }
        }

        return specification;
    }

    private Specification<T> createSpecification(Filter input) {
        switch (input.getOperator()){

            case "EQ":
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(input.getField()),
                                castToRequiredType(root.get(input.getField()).getJavaType(),
                                        input.getValue()));

            case "NEQ":
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.notEqual(root.get(input.getField()),
                                castToRequiredType(root.get(input.getField()).getJavaType(),
                                        input.getValue()));

            case "GTE":
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.ge(root.get(input.getField()),
                                (Number) castToRequiredType(
                                        root.get(input.getField()).getJavaType(),
                                        input.getValue()));

            case "LTE":
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.le(root.get(input.getField()),
                                (Number) castToRequiredType(
                                        root.get(input.getField()).getJavaType(),
                                        input.getValue()));

            case "IN":
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.in(root.get(input.getField()))
                                .value(castToRequiredType(
                                        root.get(input.getField()).getJavaType(),
                                        input.getValues()));
            case "DISTINCT":
                return (root, query, criteriaBuilder) ->
                        (Predicate) criteriaBuilder.createQuery(root.get(input.getField()).getJavaType()).distinct(true);

            default:
                throw new PestoInvalidOperationException();
        }
    }

    private Object castToRequiredType(Class fieldType, String value) {
        if(fieldType.isAssignableFrom(String.class)){
            return value;
        }else if(fieldType.isAssignableFrom(Double.class)){
            return Double.valueOf(value);
        }else if(fieldType.isAssignableFrom(Integer.class)){
            return Integer.valueOf(value);
        }else if(fieldType.isAssignableFrom(Long.class)){
            return Long.valueOf(value);
        }else if(Enum.class.isAssignableFrom(fieldType)){
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }

    private Object castToRequiredType(Class fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }
}
