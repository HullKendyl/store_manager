package com.itsthelittlethings.store_manager.service;

import com.itsthelittlethings.store_manager.EmployeeAvailability;
import com.itsthelittlethings.store_manager.EmployeeAvailabilityRepository;
import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAvailabilityService {

    private final EmployeeAvailabilityRepository employeeAvailabilityRepository;

    public EmployeeAvailabilityService(EmployeeAvailabilityRepository employeeAvailabilityRepository) {
        this.employeeAvailabilityRepository = employeeAvailabilityRepository;
    }

    public String saveAvailability(EmployeeAvailability employeeAvailability) {

        try {
            employeeAvailabilityRepository.save(employeeAvailability);
        } catch (Exception exception) {
            throw new UnableToSaveEmployeeAvailabilityException("Unable to save employee availability.");
        }

        return "Successfully saved employee availability";
    }
}
