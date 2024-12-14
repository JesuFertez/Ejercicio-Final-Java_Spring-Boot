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
    private String id;
    private String name;
    private int price;
    private String servicesProvided;
    private boolean active;
    private List<ContractDTO> contracts = new ArrayList<>();
}
