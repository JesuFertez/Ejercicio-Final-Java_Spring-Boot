package com.jesucompany.ejerciciospringboot.model.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    Plan plan;
    @Temporal(TemporalType.DATE)
    LocalDate startDate;
    @Temporal(TemporalType.DATE)
    LocalDate endDate;
}
