package com.jenny.scooter.entity;

import com.jenny.scooter.converter.PasswordConverter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity( name = "admin" )
public class Admin extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String fullname;

    @Convert(converter = PasswordConverter.class)
    @Column
    private String password;
}

