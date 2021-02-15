package com.coursework.demo.controller;

import com.coursework.demo.dto.WarehouseDTO;
import com.coursework.demo.entity.Warehouse;
import com.coursework.demo.mapper.WarehouseMapper;
import com.coursework.demo.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Warehouse API")
@RequestMapping("/v1/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final WarehouseMapper warehouseMapper;

    @Autowired
    public WarehouseController(WarehouseService warehouseService, WarehouseMapper warehouseMapper) {
        this.warehouseService = warehouseService;
        this.warehouseMapper = warehouseMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get warehouse info by id")
    public ResponseEntity<WarehouseDTO> get(@PathVariable("id") long id){
        Warehouse warehouse = warehouseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(warehouseMapper.convertToDto(warehouse));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all warehouses")
    public ResponseEntity<List<WarehouseDTO>> getPage(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(warehouseMapper.convertToDtoList(warehouseService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new warehouse")
    public ResponseEntity<WarehouseDTO> save(@RequestBody WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseService.save(warehouseMapper.convertToEntity(warehouseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseMapper.convertToDto(warehouse));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing warehouse by id")
    public ResponseEntity<WarehouseDTO> update(@PathVariable("id") long id, @RequestBody WarehouseDTO warehouseDTO) {
        if (id == warehouseDTO.getId()) {
            Warehouse warehouse = warehouseService.update(warehouseMapper.convertToEntity(warehouseDTO));
            return ResponseEntity.status(HttpStatus.OK).body(warehouseMapper.convertToDto(warehouse));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete warehouse by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Warehouse warehouse = warehouseService.getById(id);
        warehouseService.delete(warehouse);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
