package com.jenny.scooter.repository;

import com.jenny.scooter.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByUsername(String username);

    Admin findByUsername(String username);

}
