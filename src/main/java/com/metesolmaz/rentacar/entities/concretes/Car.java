package com.metesolmaz.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="plate", unique = true)
    private String plate;

    @Column(name="dailyPrice")
    private double dailyPrice;

    @Column(name="modelYear")
    private int modelYear;

    @Column(name="state")
    private int state; // 1: available, 0: not available

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

}
