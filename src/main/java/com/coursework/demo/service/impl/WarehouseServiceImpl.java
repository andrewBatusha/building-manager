package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Warehouse;
import com.coursework.demo.repository.WarehouseRepository;
import com.coursework.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class WarehouseServiceImpl implements WarehouseService {

    WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse getById(Long id) {
        return warehouseRepository.findById(id).get();
    }

    @Override
    public List<Warehouse> getAll(Pageable pageable) {
        return warehouseRepository.findAll(pageable).getContent();
    }

    @Override
    public Warehouse update(Warehouse object) {
        return warehouseRepository.save(object);
    }

    @Override
    public Warehouse save(Warehouse object) {
        return warehouseRepository.save(object);
    }

    @Override
    public Warehouse delete(Warehouse object) {
        warehouseRepository.delete(object);
        return object;
    }
}
