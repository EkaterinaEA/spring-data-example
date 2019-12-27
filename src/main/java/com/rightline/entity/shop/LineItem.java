package com.rightline.entity.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "lineitems")
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "caption")
    private String caption;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    public LineItem(String caption, double price, int quantity){
        this.caption = caption;
        this.price = price;
        this.quantity = quantity;
    }

}
