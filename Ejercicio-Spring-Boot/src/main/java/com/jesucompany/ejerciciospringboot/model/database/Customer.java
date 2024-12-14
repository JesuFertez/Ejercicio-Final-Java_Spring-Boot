package com.jesucompany.ejerciciospringboot.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.PeriodFormat;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Past
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String phone;
    private Boolean isActive;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract>contracts = new ArrayList<>();

    public Customer(String name, String lastName, String run, String city, String commune,
                    String street, int number, LocalDate dateOfBirth, String phone, Boolean isActive) {
        this.name = name;
        this.lastName = lastName;
        this.run = run;
        this.city = city;
        this.commune = commune;
        this.street = street;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.isActive = isActive;
        this.contracts = contracts;
    }
}
