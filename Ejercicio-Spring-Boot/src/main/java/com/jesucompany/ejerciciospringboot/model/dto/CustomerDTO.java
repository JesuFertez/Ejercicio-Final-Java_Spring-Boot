package com.jesucompany.ejerciciospringboot.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String lastName;
    private String run;
    private String city;
    private String commune;
    private String street;
    private int number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String phone;
    private Boolean isActive;
    private List<ContractDTO>contracts = new ArrayList<>();
}
