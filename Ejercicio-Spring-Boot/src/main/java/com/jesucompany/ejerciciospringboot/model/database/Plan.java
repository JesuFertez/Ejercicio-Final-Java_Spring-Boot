package com.jesucompany.ejerciciospringboot.model.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plans")
    private Long id;
    private String name;
    private int price;
    private String servicesProvided;
    private boolean active;
    @OneToMany(mappedBy = "plan" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts = new ArrayList<>();

    public Plan(String name, int price, String servicesProvided, boolean active) {
        this.name = name;
        this.price = price;
        this.servicesProvided = servicesProvided;
        this.active = active;
    }
    public Plan(Long id) {
        this.id = id;
    }
}
