package com.jenny.scooter.model;

import com.jenny.scooter.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreateRequestDto {

    @NotBlank(message="이름은 공백이 아니어야 합니다.")
    @Schema(description = "이름")
    private String fullname;

    @NotBlank(message="아이디는 공백이 아니어야 합니다.")
    @Schema(description = "아이디")
    private String username;

    @Pattern(regexp = "^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "비밀번호는 영문, 숫자를 혼합하여 6~20자 이내여야 합니다." )
    @Schema(description = "비밀번호")
    private String password;

    @Schema(description = "주소")
    private String address;

    @Schema(description = "나이")
    private Long age;

    @Pattern(regexp="^d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}$", message = "주민번호는 900101-1123456와 동일한 형태여야 합니다.")
    @Schema(description = "주민번호")
    private String jumin;

    public User toEntity() {
        return User.builder()
                .fullname(fullname)
                .username(username)
                .password(password)
                .address(address)
                .age(age)
                .jumin(jumin)
                .build();
    }

}
