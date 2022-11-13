package com.app.breadapp.dtos.productdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String category;
    private String image;
    private Integer quantity;
    @JsonProperty("total_amount")
    private Double totalAmount;
}
