package com.itsthelittlethings.store_manager.controller;

import com.itsthelittlethings.store_manager.service.EmployeeAvailabilityService;
import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import org.springframework.http.ResponseEntity;

public class EmployeeAvailabilityController {

    private final EmployeeAvailabilityService employeeAvailabilityService;

    public EmployeeAvailabilityController(EmployeeAvailabilityService employeeAvailabilityService) {
        this.employeeAvailabilityService = employeeAvailabilityService;
    }


    public ResponseEntity<String> insertEmployeeAvailability() {
        try  {
            employeeAvailabilityService.saveAvailability();
        } catch (UnableToSaveEmployeeAvailabilityException unableToSaveEmployeeAvailabilityException) {
            return ResponseEntity.internalServerError().body("Unable to process request at this time");
        }
        return ResponseEntity.ok().body("Inserted employee availability");
    }
}
