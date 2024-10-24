package com.jenny.scooter.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Schema( description = "스쿠터 정보 필드" )
@Entity( name = "scooter_status" )
public class ScooterStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int no;

    @Column
    private String status;

    @Column
    private String description;

}
