package com.jesucompany.ejerciciospringboot.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
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
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plans")
    private Plan plan;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @Future
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    public Contract(Customer customer, Plan plan, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
