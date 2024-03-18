package com.example.pesto.orderManagement.service;

import com.example.pesto.commons.dao.Order;
import com.example.pesto.commons.enums.OrderStatus;
import com.example.pesto.orderManagement.dto.request.CancelOrderRequestDTO;
import com.example.pesto.orderManagement.dto.request.CreateOrderRequestDTO;
import com.example.pesto.orderManagement.dto.request.UpdateOrderRequestDTO;
import com.example.pesto.orderManagement.dto.response.*;
import com.example.pesto.orderManagement.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public CreateOrderResponseDTO createOrder(String userId, CreateOrderRequestDTO requestDTO){

        Order order = new Order();
        order.setId(generateId());

        order.setStatus(OrderStatus.ORDERED);
        order.setCreationDate(System.currentTimeMillis());

        order.setModifiedDate(System.currentTimeMillis());

        order.setProdId(requestDTO.getProdId());
        order.setUserId(userId);
        order.setAddress(requestDTO.getAddress());
        order.setPaymentStatus(requestDTO.getPaymentStatus());
        order.setQuantity(requestDTO.getQuantity());
        orderRepository.save(order);

        return CreateOrderResponseDTO.builder().id(order.getId()).message("Successfully created order").build();
    }

    @Transactional
    public UpdateOrderResponseDTO updateOrder(String userId, UpdateOrderRequestDTO requestDTO){

        Order order = orderRepository.findById(requestDTO.getId()).orElse(null);
        if(order == null){
            String message = String.format("No order exist with id: %s", requestDTO.getId());
            return UpdateOrderResponseDTO.builder().id(requestDTO.getId()).message(message).build();
        }


        order.setStatus(requestDTO.getStatus());
        order.setPaymentStatus(requestDTO.getPaymentStatus());

        order.setModifiedBy(userId);
        order.setModifiedDate(System.currentTimeMillis());
        orderRepository.save(order);

        return UpdateOrderResponseDTO.builder().id(requestDTO.getId()).message("Successfully updates the order").build();
    }

    public GetOrdersResponseDTO getOrders(String userId){
        List<Order> orderList = orderRepository.findAllByUserId(userId);
        return GetOrdersResponseDTO.builder().orders(orderList).build();
    }

    public GetOrderDetailsResponseDTO getOrderDetails(String orderId){
        Order order = orderRepository.findById(orderId).orElse(null);
        return GetOrderDetailsResponseDTO.builder()
                .id(orderId)
                .prodId(order.getProdId())
                .address(order.getAddress())
                .quantity(order.getQuantity())
                .paymentStatus(order.getPaymentStatus().toString())
                .status(order.getStatus().toString())
                .creationDate(order.getCreationDate())
                .modifiedDate(order.getModifiedDate())
                .build();
    }

    @Transactional
    public CancelOrderResponseDTO cancelOrder(String userId, CancelOrderRequestDTO requestDTO){
        Order order = orderRepository.findById(requestDTO.getId()).orElse(null);
        if(order == null){
            String message = String.format("No order exist with id: %s", requestDTO.getId());
            return CancelOrderResponseDTO.builder().message(message).build();
        }

        order.setStatus(OrderStatus.CANCELLED);
        order.setModifiedBy(userId);
        orderRepository.save(order);

        return CancelOrderResponseDTO.builder().id(requestDTO.getId()).message("Successfully Cancelled the Order").build();
    }

    private String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
