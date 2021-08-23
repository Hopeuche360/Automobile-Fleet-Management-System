package com.example.fieetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "customer")
public class Customer extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;
    @OneToOne
    private Branch branch;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private Manager manager;
}
