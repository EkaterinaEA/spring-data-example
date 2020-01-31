package com.rightline.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule")
@Accessors(chain = true)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cron")
    private String cron;

    public Schedule(String cron) {
        this.cron = cron;
    }

}
