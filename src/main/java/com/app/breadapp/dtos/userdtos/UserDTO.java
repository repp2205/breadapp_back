package com.app.breadapp.dtos.userdtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private Integer branchOfficeId;
    private Integer bakeryId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Integer role;
    private Integer status;
}
