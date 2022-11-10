package com.app.breadapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "breadapp", name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "user_id")
    private String userId;
    @Column
    private String orderDate;
    @Column(name = "pick_up_time")
    private String pickUpTime;
    @Column
    private String status;
}
