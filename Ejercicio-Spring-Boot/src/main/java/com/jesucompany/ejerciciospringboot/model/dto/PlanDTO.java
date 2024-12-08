package com.jesucompany.ejerciciospringboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanDTO {
    String name;
    int price;
    String servicesProvided;
    private List<ContractDTO> contracts = new ArrayList<>();
}
