package com.jesucompany.ejerciciospringboot.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;
    private String name;
    private String lastName;
    private String run;
    private String city;
    private String commune;
    private String street;
    private int number;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String phone;
    private Boolean isActive;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract>contracts = new ArrayList<>();
}
