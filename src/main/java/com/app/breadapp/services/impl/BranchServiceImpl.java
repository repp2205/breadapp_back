package com.app.breadapp.services.impl;

import com.app.breadapp.dtos.bakerydtos.BakeryDTO;
import com.app.breadapp.dtos.bakerydtos.BrachDTO;
import com.app.breadapp.dtos.productdtos.ProductBranchDTO;
import com.app.breadapp.dtos.productdtos.ProductDTO;
import com.app.breadapp.entities.Bakery;
import com.app.breadapp.entities.BranchOffice;
import com.app.breadapp.repositories.BakeryRepository;
import com.app.breadapp.repositories.BranchOfficeRepository;
import com.app.breadapp.services.BakeryService;
import com.app.breadapp.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BakeryRepository bakeryRepository;

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Override
    public List<ProductBranchDTO> getProductFromBranch(Integer branchId) {
        List<Object> productsObjects = branchOfficeRepository.findBranchProductsByBranchId(branchId);
        List<ProductBranchDTO> branchDTOList = new ArrayList<>();

        for (int i = 0; i < productsObjects.size(); i++) {
            ProductBranchDTO productBranchDTO = new ProductBranchDTO();
            List<?> product = Arrays.asList((Object[])productsObjects.get(i));
            productBranchDTO.setProductId((Integer) product.get(0));
            productBranchDTO.setName((String) product.get(1));
            productBranchDTO.setDescription((String) product.get(2));
            productBranchDTO.setCategory((String) product.get(3));
            productBranchDTO.setImage((String) product.get(4));
            productBranchDTO.setQuantity(Integer.parseInt(((Short) product.get(5)).toString()));
            productBranchDTO.setAmount((Double) product.get(6));
            branchDTOList.add(productBranchDTO);
        }
        return branchDTOList;
    }
}
