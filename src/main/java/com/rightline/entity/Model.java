package com.rightline.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "models")
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

    @ManyToOne(targetEntity = LegoSet.class)
    private LegoSet legoSet;

    public Model(String name, String description, ModelMapEntry modelMapEntry, LegoSet legoSet) {
        this.name = name;
        this.description = description;
        this.modelMapEntry = modelMapEntry;
        this.legoSet = legoSet;
    }

    public Model(String name, String description, LegoSet legoSet) {
        this.name = name;
        this.description = description;
        this.legoSet = legoSet;
    }

    public Model(Integer id, String name, String description, LegoSet legoSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.legoSet = legoSet;
    }

}
