package com.metesolmaz.rentacar.entities.concretes;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;


@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
