package com.jesucompany.ejerciciospringboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    CustomerDTO customer;
    PlanDTO plan;
    Date startDate;
    Date endDate;
}
