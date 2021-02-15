package com.coursework.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "buildings")
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 35, nullable = false)
    private String name;

    private String geolocation;

    @OneToMany(mappedBy = "building")
    private List<Equipment> equipments = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<Ledger> ledgers = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<Warehouse> warehouses = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<Employee> employees = new ArrayList<>();
}
