package com.app.breadapp.dtos.productdtos;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String category;
    private String image;
    private Integer quantity;
    private Double totalAmount;
}
