package com.coursework.demo.repository;

import com.coursework.demo.entity.Warehouse;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Long> {
}
