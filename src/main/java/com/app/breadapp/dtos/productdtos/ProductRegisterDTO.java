package com.app.breadapp.dtos.productdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductRegisterDTO {
    private Integer productId;
    private Integer quantity;
    private Double totalAmount;
}
