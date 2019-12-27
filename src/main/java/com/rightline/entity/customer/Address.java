package com.rightline.entity.customer;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "legosets")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "location")
    private Point location;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipCode;

    public Address(Point location, String street, String zipCode){
        this.location = location;
        this.street = street;
        this.zipCode = zipCode;
    }
}
