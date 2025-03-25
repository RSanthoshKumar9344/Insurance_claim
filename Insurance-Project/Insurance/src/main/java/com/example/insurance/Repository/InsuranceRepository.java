package com.example.insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.insurance.Entity.InsuEntity;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuEntity, Long> {
}
