package com.example.pesto.central.controller.api;

import com.example.pesto.auth.util.CustomUser;
import com.example.pesto.commons.enums.Role;
import com.example.pesto.orderManagement.dto.request.CancelOrderRequestDTO;
import com.example.pesto.orderManagement.dto.request.CreateOrderRequestDTO;
import com.example.pesto.orderManagement.dto.request.UpdateOrderRequestDTO;
import com.example.pesto.orderManagement.dto.response.*;
import com.example.pesto.orderManagement.service.OrderService;
import com.example.pesto.commons.exceptions.PestoUnAuthorisedUserException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(Endpoints.OrderAPI.BASE_URL)
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(Endpoints.OrderAPI.CREATE)
    public CreateOrderResponseDTO createOrder(@RequestHeader("Authorization") String token, @Valid @RequestBody CreateOrderRequestDTO requestDTO){
        CustomUser contextUser = authenticate();
        log.info("API request to create order for userId : "+contextUser.getId());
        return orderService.createOrder(token, contextUser.getId(), requestDTO);
    }

    @PostMapping(Endpoints.OrderAPI.UPDATE)
    public UpdateOrderResponseDTO updateOrder(@Valid @RequestBody UpdateOrderRequestDTO requestDTO){
        CustomUser contextUser = authenticate();
        log.info("API request to update product status with userId : "+contextUser.getId());

        if(!contextUser.getRole().equals(Role.ADMIN)){
            throw new PestoUnAuthorisedUserException();
        }
        return orderService.updateOrder(contextUser.getId(), requestDTO);
    }

    @GetMapping(Endpoints.OrderAPI.VIEW)
    public GetOrdersResponseDTO viewOrders(){
        CustomUser contextUser = authenticate();
        log.info("API request to view order for userId: "+contextUser.getId());
        return orderService.getOrders(contextUser.getId());
    }

    @GetMapping(Endpoints.OrderAPI.VIEW_DETAILS)
    public GetOrderDetailsResponseDTO viewOrderDetails(@RequestHeader("Authorization") String token, @Valid @RequestParam String orderId){
        log.info("API request to view product details");
        return orderService.getOrderDetails(token, orderId);
    }

    @PostMapping(Endpoints.OrderAPI.CANCEL)
    public CancelOrderResponseDTO cancelOrder(@Valid @RequestBody CancelOrderRequestDTO requestDTO){
        CustomUser contextUser = authenticate();
        log.info("API request to cancel order by userId: "+contextUser.getId());
        return orderService.cancelOrder(contextUser.getId(), requestDTO);
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
