package com.app.breadapp.dtos.productdtos;

import lombok.Data;

@Data
public class ProductBranchDTO {
    private Integer productId;
    private String name;
    private String description;
    private String category;
    private String image;
    private Integer quantity;
    private Double amount;
}
