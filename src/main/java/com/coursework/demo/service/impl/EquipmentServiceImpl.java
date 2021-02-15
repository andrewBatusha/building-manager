package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Equipment;
import com.coursework.demo.repository.EquipmentRepository;
import com.coursework.demo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EquipmentServiceImpl implements EquipmentService {

    EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment getById(Long id) {
        return equipmentRepository.findById(id).get();
    }

    @Override
    public List<Equipment> getAll(Pageable pageable) {
        return equipmentRepository.findAll(pageable).getContent();
    }

    @Override
    public Equipment update(Equipment object) {
        return equipmentRepository.save(object);
    }

    @Override
    public Equipment save(Equipment object) {
        return equipmentRepository.save(object);
    }

    @Override
    public Equipment delete(Equipment object) {
        equipmentRepository.delete(object);
        return object;
    }
}
