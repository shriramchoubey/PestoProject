package com.example.pesto.commons.dao;


import com.example.pesto.commons.enums.OrderStatus;
import com.example.pesto.commons.enums.PaymentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data @Table(name="orders")
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseDAO {

    @Id
    private String id;

    private String prodId;

    private String userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String address;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private int quantity;
    private String modifiedBy;

    @Version
    private Integer version;

    private Long creationDate;
    private Long modifiedDate;

}
