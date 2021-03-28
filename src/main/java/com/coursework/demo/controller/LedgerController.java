package com.coursework.demo.controller;

import com.coursework.demo.dto.AddLedgerDTO;
import com.coursework.demo.dto.ExpensesDTO;
import com.coursework.demo.dto.LedgerDTO;
import com.coursework.demo.entity.Ledger;
import com.coursework.demo.mapper.LedgerMapper;
import com.coursework.demo.service.LedgerService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Ledger API")
@RequestMapping("/v1/ledgers")
public class LedgerController {

    private final LedgerService ledgerService;
    private final LedgerMapper ledgerMapper;

    @Autowired
    public LedgerController(LedgerService ledgerService, LedgerMapper ledgerMapper) {
        this.ledgerService = ledgerService;
        this.ledgerMapper = ledgerMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get ledger info by id")
    public ResponseEntity<LedgerDTO> get(@PathVariable("id") long id) {
        Ledger ledger = ledgerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ledgerMapper.convertToDto(ledger));
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpensesDTO>> expensesList(@RequestParam String name) {
        return ResponseEntity.ok().body(ledgerService.getExpensesName(name));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all ledgers")
    public ResponseEntity<List<LedgerDTO>> getPage(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(ledgerMapper.convertToDtoList(ledgerService.getAll(pageable)));
    }

    @PostMapping
    @ApiOperation(value = "Create new ledger")
    public ResponseEntity<LedgerDTO> save(@RequestBody AddLedgerDTO addLedgerDTO) {
        Ledger ledger = ledgerService.save(ledgerMapper.convertToEntity(addLedgerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(ledgerMapper.convertToDto(ledger));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing ledger by id")
    public ResponseEntity<LedgerDTO> update(@PathVariable("id") long id, @RequestBody LedgerDTO ledgerDTO) {
        if (id == ledgerDTO.getId()) {
            Ledger ledger = ledgerService.save(ledgerMapper.convertToEntity(ledgerDTO));
            return ResponseEntity.status(HttpStatus.OK).body(ledgerMapper.convertToDto(ledger));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete ledger by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Ledger ledger = ledgerService.getById(id);
        ledgerService.delete(ledger);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
