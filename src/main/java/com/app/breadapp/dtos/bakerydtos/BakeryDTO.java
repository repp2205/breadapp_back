package com.app.breadapp.dtos.bakerydtos;

import com.app.breadapp.entities.Bakery;
import com.app.breadapp.entities.BranchOffice;
import lombok.Data;

import java.util.List;

@Data
public class BakeryDTO {
    private Integer id;
    private String name;
    private String nit;
    private String address;
    private String supportEmail;
    private String contactPhone;
    private Integer status;
    private List<BrachDTO> campus;
}
