package com.app.breadapp.dtos.bakerydtos;

import lombok.Data;

@Data
public class BrachDTO {
    private Integer id;
    private Integer bakeryId;
    private String name;
    private String contactPhone;
    private String address;
    private String openingTime;
    private String closingTime;
    private Integer status;
}
