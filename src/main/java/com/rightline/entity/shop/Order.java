package com.rightline.entity.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customerid")
    private String customerId;

    @Column(name = "orderdate")
    private Date orderDate;

    @ManyToOne(targetEntity = LineItem.class)
    private LineItem item;

    public Order(String customerId, Date orderDate, LineItem item){
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.item = item;
    }

    public Order(LineItem item){
        this.item = item;
    }

}
