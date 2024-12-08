package com.jesucompany.ejerciciospringboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String run;
    private String city;
    private String commune;
    private String street;
    private int number;
    private Date dateOfBirth;
    private String phone;
    private Boolean isActive;
    private List<ContractDTO>contracts = new ArrayList<>();
}
