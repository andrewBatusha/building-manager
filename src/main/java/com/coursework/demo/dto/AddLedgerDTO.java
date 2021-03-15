package com.coursework.demo.dto;

import com.coursework.demo.entity.Building;
import com.coursework.demo.entity.enums.Bookkeeping;
import com.coursework.demo.entity.enums.ProcurementType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddLedgerDTO {

    private String name;

    private Long quantity;

    private Bookkeeping bookkeeping;

    private ProcurementType procurementType;

    private String unitOfMeasurement;

    private Long price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Building building;
}
