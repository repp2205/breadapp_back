package com.app.breadapp.dtos.orderdtos;

import com.app.breadapp.dtos.productdtos.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Integer orderId;
    private String orderDate;
    private String pickUpTime;
    private Integer status;
    private List<ProductDTO> products;
}
