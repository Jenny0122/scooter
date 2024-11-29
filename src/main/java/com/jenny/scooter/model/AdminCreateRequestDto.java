package com.jenny.scooter.model;

import com.jenny.scooter.entity.Admin;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminCreateRequestDto {

    @NotBlank(message="아이디는 공백이 아니어야 합니다.")
    @Schema(description = "아이디")
    private String username;

    @Schema(description = "이름")
    @NotBlank(message="이름은 공백이 아니어야 합니다.")
    @Size(min = 2, max = 5)
    private String fullname;

    @Pattern(regexp = "^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "비밀번호는 영문, 숫자를 혼합하여 6~20자 이내여야 합니다." )
    @Schema(description = "비밀번호")
    private String password;

    public Admin toEntity() {
        return Admin.builder()
                .username(username)
                .fullname(fullname)
                .password(password)
                .build();
    }

}
