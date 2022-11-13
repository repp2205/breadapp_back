package com.app.breadapp.dtos.orderdtos;

import com.app.breadapp.dtos.productdtos.ProductDTO;
import com.app.breadapp.dtos.productdtos.ProductRegisterDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrderRegisterDTO {
    private Integer userId;
    private String branchOfficeId;
    private String pickUpTime;
    private List<ProductRegisterDTO> products;
}
