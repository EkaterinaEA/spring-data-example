package com.krasnova.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne(targetEntity = ModelMapEntry.class)
    private ModelMapEntry modelMapEntry;

    public Model(String name, String description, ModelMapEntry modelMapEntry) {
        this.name = name;
        this.description = description;
        this.modelMapEntry = modelMapEntry;
    }

}
