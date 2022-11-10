package com.app.breadapp.dtos.userdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterDTO {
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Integer role;
}
