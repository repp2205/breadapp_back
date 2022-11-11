package com.app.breadapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "branchoffice")
public class BranchOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "bakery_id")
    private Integer bakeryId;
    @Column
    private String name;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column
    private String address;
    @Column(name = "opening_time")
    private String openingTime;
    @Column(name = "closing_time")
    private String closingTime;
    @Column
    private Integer status;
}
