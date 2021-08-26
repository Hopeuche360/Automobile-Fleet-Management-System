package com.example.fieetmanagement.models;

import com.example.fieetmanagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false)
    private Long id;

    private String brand;
    private String model;
    private String color;
    private Double price;
    private String transmission;
    private Long mileage;
    private String vehicleType;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String vin;
    private Date createdAt;
//    @ManyToOne
//    private Branch branch;
}
