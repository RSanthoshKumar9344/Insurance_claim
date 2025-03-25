package com.example.insurance.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insurance.Entity.InsuEntity;
import com.example.insurance.Repository.InsuranceRepository;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository repository;

    public InsuEntity createInsurance(InsuEntity entity) {
        return repository.save(entity);
    }

    public List<InsuEntity> getAllInsurancePolicies() {
        return repository.findAll();
    }

    public Optional<InsuEntity> getInsuranceById(Long id) {
        return repository.findById(id);
    }

    public InsuEntity updateInsurance(InsuEntity entity) {
        return repository.save(entity);
    }

    public void deleteInsurance(Long id) {
        repository.deleteById(id);
    }
    public double IP(InsuEntity v) {
        double tp = (v.getSumInterest() * v.getPremiumRate() / 100); // Use instance variables
        if (v.getAge() >= 18 && v.getAge()<= 30) {
            return tp + 1000;
        } else if (v.getAge() >= 31 && v.getAge() <= 45) {
            return tp + 3000;
        } else if (v.getAge() >= 46 && v.getAge() <= 60) {
            return tp + 5000;
        }
        return tp;
    }

    }

