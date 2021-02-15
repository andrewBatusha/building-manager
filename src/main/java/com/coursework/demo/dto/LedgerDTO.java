package com.coursework.demo.dto;

import com.coursework.demo.entity.Building;
import com.coursework.demo.entity.enums.Bookkeeping;
import com.coursework.demo.entity.enums.ProcurementType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LedgerDTO {

    private Long id;

    private String name;

    private Long quantity;

    private Bookkeeping bookkeeping;

    private ProcurementType procurementType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm", lenient = OptBoolean.FALSE, timezone = "GMT+3")
    private LocalDateTime dueTime;

    private String unitOfMeasurement;

    private Long price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Building building;
}
