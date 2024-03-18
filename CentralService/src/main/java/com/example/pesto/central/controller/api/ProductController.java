package com.example.pesto.central.controller.api;

import com.example.pesto.auth.util.CustomUser;
import com.example.pesto.commons.enums.Role;
import com.example.pesto.productManagement.dto.request.CreateProductRequestDTO;
import com.example.pesto.productManagement.dto.request.DeleteProductRequestDTO;
import com.example.pesto.productManagement.dto.request.UpdateProductRequestDTO;
import com.example.pesto.productManagement.dto.response.*;
import com.example.pesto.commons.exceptions.PestoUnAuthorisedUserException;
import com.example.pesto.productManagement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(Endpoints.ProductAPI.BASE_URL)
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(Endpoints.ProductAPI.CREATE)
    public CreateProductResponseDTO createProducts(@Valid @RequestBody CreateProductRequestDTO requestDTO){
        log.info("API request to create product");
        CustomUser contextUser = authenticate();
        if(!contextUser.getRole().equals(Role.ADMIN)){
            throw new PestoUnAuthorisedUserException();
        }
        return productService.createProduct(contextUser.getId(), requestDTO);
    }

    @PutMapping(Endpoints.ProductAPI.UPDATE)
    public UpdateProductResponseDTO updateProduct(@Valid @RequestBody UpdateProductRequestDTO requestDTO){
        log.info("API request to create product");
        CustomUser contextUser = authenticate();
        if(!contextUser.getRole().equals(Role.ADMIN)){
            throw new PestoUnAuthorisedUserException();
        }
        return productService.updateProduct(contextUser.getId(), requestDTO);
    }

    @GetMapping(Endpoints.ProductAPI.VIEW)
    public GetProductsResponseDTO viewProducts(){
        log.info("API request to get products list");
        return productService.getProducts();
    }

    @GetMapping(Endpoints.ProductAPI.VIEW_DETAIL)
    public ViewProductDetailsResponsDTO viewProductDetail(@Valid @RequestParam String prodId){
        log.info("API request to view product details");
        return productService.viewProductDetail(prodId);
    }

    @DeleteMapping(Endpoints.ProductAPI.DELETE)
    public DeleteProductResponseDTO deleteProducts(@Valid @RequestBody DeleteProductRequestDTO requestDTO){
        log.info("API request to delete product");
        CustomUser contextUser = authenticate();
        if(!contextUser.getRole().equals(Role.ADMIN)){
            throw new PestoUnAuthorisedUserException();
        }
        return productService.deleteProduct(requestDTO);
    }

    private CustomUser authenticate(){
        val auth = SecurityContextHolder.getContext().getAuthentication();
        val contextUser = (CustomUser) auth.getPrincipal();
        if(contextUser == null){
            throw new PestoUnAuthorisedUserException();
        }
        return contextUser;
    }
}
