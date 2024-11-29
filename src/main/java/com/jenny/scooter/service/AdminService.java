package com.jenny.scooter.service;


import com.jenny.scooter.model.AdminCreateRequestDto;
import com.jenny.scooter.entity.Admin;
import com.jenny.scooter.exception.DuplicatedValueException;
import com.jenny.scooter.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@Slf4j
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public Admin saveAdmin(AdminCreateRequestDto adminCreateRequestDto) {

        log.info("admin: {}", adminCreateRequestDto);
        String username = adminCreateRequestDto.getUsername();
        if(adminRepository.existsByUsername(username)) {
            throw new DuplicatedValueException("중복된 ID가 존재합니다.");
        }

        return adminRepository.save(adminCreateRequestDto.toEntity());
    }


    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId).get();
    }

    public Admin getAdminByUsername(String adminUsername) {
        return adminRepository.findByUsername(adminUsername);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
