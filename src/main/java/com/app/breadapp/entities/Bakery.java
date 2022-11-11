package com.app.breadapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "bakery")
public class Bakery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String nit;
    @Column
    private String address;
    @Column(name = "support_email")
    private String supportEmail;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column
    private Integer status;
}
