package com.coursework.demo.controller;

import com.coursework.demo.dto.EquipmentDTO;
import com.coursework.demo.entity.Equipment;
import com.coursework.demo.mapper.EquipmentMapper;
import com.coursework.demo.service.EquipmentService;
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
@Api(tags = "Equipment API")
@RequestMapping("/v1/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final EquipmentMapper equipmentMapper;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, EquipmentMapper equipmentMapper) {
        this.equipmentService = equipmentService;
        this.equipmentMapper = equipmentMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get equipment info by id")
    public ResponseEntity<EquipmentDTO> get(@PathVariable("id") long id){
        Equipment equipment = equipmentService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(equipmentMapper.convertToDto(equipment));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all equipments")
    public ResponseEntity<List<EquipmentDTO>> getPage(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(equipmentMapper.convertToDtoList(equipmentService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new equipment")
    public ResponseEntity<EquipmentDTO> save(@RequestBody EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentService.save(equipmentMapper.convertToEntity(equipmentDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentMapper.convertToDto(equipment));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing equipment by id")
    public ResponseEntity<EquipmentDTO> update(@PathVariable("id") long id, @RequestBody EquipmentDTO equipmentDTO) {
        if (id == equipmentDTO.getId()) {
            Equipment equipment = equipmentService.update(equipmentMapper.convertToEntity(equipmentDTO));
            return ResponseEntity.status(HttpStatus.OK).body(equipmentMapper.convertToDto(equipment));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete equipment by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Equipment equipment = equipmentService.getById(id);
        equipmentService.delete(equipment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
