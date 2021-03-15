package com.coursework.demo.mapper;

import com.coursework.demo.dto.AddLedgerDTO;
import com.coursework.demo.dto.LedgerDTO;
import com.coursework.demo.entity.Ledger;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LedgerMapper {

    LedgerDTO convertToDto(Ledger ledger);

    Ledger convertToEntity(LedgerDTO ledgerDTO);

    Ledger convertToEntity(AddLedgerDTO ledgerDTO);

    List<LedgerDTO> convertToDtoList(List<Ledger> ledgers);

}