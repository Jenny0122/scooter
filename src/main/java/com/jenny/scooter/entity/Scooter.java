package com.jenny.scooter.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Schema( description = "스쿠터 정보 필드" )
@Entity( name = "scooter" )
public class Scooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int no;

    @Column
    private String model_number;

    @Column
    private String serial_number;

    @Column
    private String name;

    @Column
    private int status_value;

    @Column
    private LocalDateTime createDt;

    @Column
    private LocalDateTime updateDt;

}
