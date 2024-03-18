package com.example.pesto.productManagement.service;

import com.example.pesto.commons.dao.Product;
import com.example.pesto.productManagement.dto.request.CreateProductRequestDTO;
import com.example.pesto.productManagement.dto.request.DeleteProductRequestDTO;
import com.example.pesto.productManagement.dto.request.UpdateProductRequestDTO;
import com.example.pesto.productManagement.dto.response.*;
import com.example.pesto.productManagement.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public CreateProductResponseDTO createProduct(String userId, CreateProductRequestDTO requestDTO){

        String createdById = userId;
        Product product = new Product();
        product.setCreatedBy(createdById);
        product.setLastUpdatedBy(createdById);
        product.setName(requestDTO.getName());
        product.setImage(requestDTO.getImage());
        product.setDescription(requestDTO.getDescription());
        product.setId(generateId());
        product.setCreationDate(System.currentTimeMillis());
        product.setModifiedDate(System.currentTimeMillis());

        productRepository.save(product);

        return CreateProductResponseDTO.builder().id(product.getId()).message("Successfully create product").build();
    }

    @Transactional
    public UpdateProductResponseDTO updateProduct(String userId, UpdateProductRequestDTO requestDTO){

        Product product = productRepository.findById(requestDTO.getId()).orElse(null);
        if(product == null){
            String message = String.format("No product exist with id: %s", requestDTO.getId());
            return UpdateProductResponseDTO.builder().message(message).build();
        }

        String updatedById = userId;

        product.setLastUpdatedBy(updatedById);
        product.setName(requestDTO.getName());
        product.setImage(requestDTO.getImage());
        product.setDescription(requestDTO.getDescription());
        product.setModifiedDate(System.currentTimeMillis());

        productRepository.save(product);

        String message = String.format("Successfully update the product with id: %s", requestDTO.getId());
        return UpdateProductResponseDTO.builder().message(message).build();
    }

    public GetProductsResponseDTO getProducts(){
        List<Product> productList = productRepository.findAll();
        return GetProductsResponseDTO.builder().products(productList).build();
    }

    public ViewProductDetailsResponsDTO viewProductDetail(String prodId){
        Product prod = productRepository.findById(prodId).orElse(null);
        if(prod == null){
            String message = String.format("No product exist with id: %s", prodId);
            return ViewProductDetailsResponsDTO.builder().message(message).build();
        }

        return ViewProductDetailsResponsDTO.builder()
                .id(prod.getId())
                .name(prod.getName())
                .description(prod.getDescription())
                .image(prod.getImage())
                .creationDate(prod.getCreationDate())
                .build();
    }


    @Transactional
    public DeleteProductResponseDTO deleteProduct(DeleteProductRequestDTO requestDTO){
        productRepository.deleteById(requestDTO.getId());
        String message = String.format("Successfully Delete the Product by Id: %s", requestDTO.getId());
        return DeleteProductResponseDTO.builder().message(message).build();
    }

    private String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
