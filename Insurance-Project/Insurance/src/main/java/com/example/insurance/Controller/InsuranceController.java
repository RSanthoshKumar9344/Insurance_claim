package com.example.insurance.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.Entity.InsuEntity;
import com.example.insurance.Service.InsuranceService;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createInsurance(@RequestBody InsuEntity entity) {
        Double a = service.IP(entity); // Calculate the value
        InsuEntity savedEntity = service.createInsurance(entity); // Save the entity

        // Create a response map
        Map<String, Object> response = new HashMap<>();
        response.put("message", "The SI is: " + a);
        response.put("createdEntity", savedEntity);

        return ResponseEntity.ok(response); // Return the response map
    }

    @GetMapping
    public ResponseEntity<List<InsuEntity>> getAllInsurancePolicies() {
        return ResponseEntity.ok(service.getAllInsurancePolicies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<InsuEntity>> getInsuranceById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInsuranceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuEntity> updateInsurance(@PathVariable Long id, @RequestBody InsuEntity entity) {
        entity.setId(id); // Set the ID to ensure updating the correct record
        return ResponseEntity.ok(service.updateInsurance(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable Long id) {
        service.deleteInsurance(id);
        return ResponseEntity.ok("Insurance policy deleted successfully!");
    }
}
