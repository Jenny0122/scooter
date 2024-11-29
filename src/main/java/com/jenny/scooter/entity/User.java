package com.jenny.scooter.entity;

import com.jenny.scooter.converter.PasswordConverter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity( name = "user" )
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String fullname;

    @Column
    private String username;

    @Convert(converter = PasswordConverter.class)
    @Column
    private String password;

    @Column
    private String address;

    @Column
    private Long age;

    @Column
    private String jumin;

}
