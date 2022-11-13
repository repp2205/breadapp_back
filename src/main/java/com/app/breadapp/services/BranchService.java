package com.app.breadapp.services;

import com.app.breadapp.dtos.bakerydtos.BakeryDTO;
import com.app.breadapp.dtos.productdtos.ProductBranchDTO;
import com.app.breadapp.dtos.productdtos.ProductDTO;

import java.util.List;

public interface BranchService {
    List<ProductBranchDTO> getProductFromBranch(Integer branchId);
}
