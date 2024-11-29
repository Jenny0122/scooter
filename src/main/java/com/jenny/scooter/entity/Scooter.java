package com.jenny.scooter.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "scooter")
public class Scooter extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="model_number")
    private String modelNumber;

    @Column(name="serial_number")
    private String serialNumber;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "status_no")
    private ScooterStatus statusNo;
}
