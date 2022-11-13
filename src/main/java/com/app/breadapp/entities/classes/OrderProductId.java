package com.app.breadapp.entities.classes;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderProductId implements Serializable {
    public Integer orderId;
    public Integer productId;
}
