package com.coursework.demo.repository;

import com.coursework.demo.entity.Equipment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, Long> {
}
