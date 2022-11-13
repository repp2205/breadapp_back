package com.app.breadapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "orderproduct")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_id")
    private Integer productId;
    @Column
    private Integer quantity;
    @Column(name = "total_amount")
    private Double totalAmount;
}
