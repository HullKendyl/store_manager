package com.itsthelittlethings.store_manager.controller;

import com.itsthelittlethings.store_manager.EmployeeAvailability;
import com.itsthelittlethings.store_manager.service.EmployeeAvailabilityService;
import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAvailabilityController {

    private final EmployeeAvailabilityService employeeAvailabilityService;

    public EmployeeAvailabilityController(EmployeeAvailabilityService employeeAvailabilityService) {
        this.employeeAvailabilityService = employeeAvailabilityService;
    }

    @PostMapping("/api/add-availability")
    public ResponseEntity<String> insertEmployeeAvailability(@RequestBody EmployeeAvailability employeeAvailability) {

        try  {
            employeeAvailabilityService.saveAvailability(employeeAvailability);
        } catch (UnableToSaveEmployeeAvailabilityException unableToSaveEmployeeAvailabilityException) {
            return ResponseEntity.internalServerError().body("Unable to process request at this time");
        }
        return ResponseEntity.ok().body("Inserted employee availability");
    }
}
