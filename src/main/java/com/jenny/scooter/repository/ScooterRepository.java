package com.jenny.scooter.repository;

import com.jenny.scooter.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
