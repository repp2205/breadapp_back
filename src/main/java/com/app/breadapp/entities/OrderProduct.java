package com.app.breadapp.entities;

import com.app.breadapp.entities.classes.OrderProductId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(OrderProductId.class)
@Table(schema = "breadapp", name = "orderproduct")
public class OrderProduct implements Serializable {
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Column
    private Integer quantity;
    @Column(name = "total_amount")
    private Double totalAmount;
}
