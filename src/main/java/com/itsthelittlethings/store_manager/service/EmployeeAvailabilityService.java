package com.itsthelittlethings.store_manager.service;

import com.itsthelittlethings.store_manager.EmployeeAvailability;
import com.itsthelittlethings.store_manager.EmployeeAvailabilityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAvailabilityService {

    private final EmployeeAvailabilityRepository employeeAvailabilityRepository;

    public EmployeeAvailabilityService(EmployeeAvailabilityRepository employeeAvailabilityRepository) {
        this.employeeAvailabilityRepository = employeeAvailabilityRepository;
    }

    public String saveAvailability(EmployeeAvailability employeeAvailability) {
        employeeAvailabilityRepository.save(employeeAvailability);
        return "Successfully saved employee availability";
    }
}
