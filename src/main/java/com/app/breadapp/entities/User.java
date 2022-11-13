package com.app.breadapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "branch_office_id")
    private Integer branchOfficeId;
    @Column(name = "bakery_id")
    private Integer bakeryId;
    @Column
    private String name;
    @Column(name = "last_name")
    private String LastName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Column
    private int role;
    @Column
    private int status;
}
