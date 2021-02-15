package com.coursework.demo.dto;

import com.coursework.demo.entity.Employee;
import com.coursework.demo.entity.Equipment;
import com.coursework.demo.entity.Ledger;
import com.coursework.demo.entity.Warehouse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildingDTO {
    private Long id;

    private String name;

    private String geolocation;

    private List<Equipment> equipments = new ArrayList<>();

    private List<Ledger> ledgers = new ArrayList<>();

    private List<Warehouse> warehouses = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();
}
