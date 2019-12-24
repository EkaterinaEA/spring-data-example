package com.rightline.entity;

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
@Table(name = "manuals")
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @ManyToOne(targetEntity = LegoSet.class)
    private LegoSet legoSet;

    public Manual(String author, String text, LegoSet legoset) {
        this.author = author;
        this.text = text;
        this.legoSet = legoset;
    }

}
