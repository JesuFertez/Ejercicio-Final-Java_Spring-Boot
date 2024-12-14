package com.jesucompany.ejerciciospringboot.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    Long id;
    Long customerId;
    Long planId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate startDate;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate endDate;
}
