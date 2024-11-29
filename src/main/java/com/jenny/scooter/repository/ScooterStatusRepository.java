package com.jenny.scooter.repository;

import com.jenny.scooter.entity.ScooterStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterStatusRepository extends JpaRepository<ScooterStatus, Long> {
}
