package com.app.breadapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "branch_office_id")
    private Integer branchOfficeid;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "pick_up_time")
    private String pickUpTime;
    private Integer status;
}
