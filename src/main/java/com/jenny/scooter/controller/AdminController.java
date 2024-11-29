package com.jenny.scooter.controller;

import com.jenny.scooter.model.AdminCreateRequestDto;
import com.jenny.scooter.entity.Admin;
import com.jenny.scooter.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name="Admin API", description = "관리자 API")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    // * Swagger 적용할 것. 아래의 Link 참고
    // - DTO의 모든 필드에 상세정보 작성
    // - Controller의 모든 메소드에 상세정보 작성
    // - Swagger UI에서 잘 표시되는지 확인
    // https://twojun-space.tistory.com/201
    @PostMapping
    @Operation(summary = "Admin 계정 생성", description = "Admin 계정을 생성합니다.")
    public Admin createAdmin(@Parameter(description = "Admin 생성 요청 DTO") @Valid @RequestBody AdminCreateRequestDto adminCreateRequestDto) {

        return adminService.saveAdmin(adminCreateRequestDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Admin 계정 조회", description = "Admin 계정을 NO로 조회합니다.")
    public Admin findAdminById(@Parameter(description = "Admin의 no") @PathVariable(name = "id")  @Min(1) @Valid Long adminId) {

        return adminService.getAdminById(adminId);
    }

    @GetMapping
    @Operation(summary = "Admin 계정 조회", description = "Admin 계정을 username(아이디)로 조회합니다.")
    public Admin findAdminByUsername(@Parameter(description = "Admin의 username(아이디)") @Valid @RequestParam(name = "username") String adminUsername) {

        return adminService.getAdminByUsername(adminUsername);
    }
}
