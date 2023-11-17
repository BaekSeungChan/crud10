package com.example.crud10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer price;

    @OneToMany(mappedBy = "information", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fruit> fruits;
}
