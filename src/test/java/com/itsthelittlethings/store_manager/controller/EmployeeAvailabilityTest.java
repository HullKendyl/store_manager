package com.itsthelittlethings.store_manager.controller;

import com.itsthelittlethings.store_manager.controller.EmployeeAvailabilityController;
import com.itsthelittlethings.store_manager.service.EmployeeAvailabilityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class EmployeeAvailabilityTest {

    @Mock
    private EmployeeAvailabilityService employeeAvailabilityService;

    @Nested
    @DisplayName("Given an employee wants to share their availability")
    class GivenAnEmployeeWantsToShareTheirAvailabilityTest {

        @Nested
        @DisplayName("When an employee enters their availability for the first time")
        class WhenAnEmployeeEntersTheirAvailabilityForTheFirstTimeTest {

            @Test
            @DisplayName("Then insertEmployeeAvailability returns 200 OK status")
            void thenInsertEmployeeAvailabilityReturns200OkStatus() {
                final var employeeAvailabilityController = new EmployeeAvailabilityController(employeeAvailabilityService);

                final var result = employeeAvailabilityController.insertEmployeeAvailability();

                Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
            }

            @Test
            @DisplayName("Then insertEmployeeAvailability returns success message")
            void thenInsertEmployeeAvailabilityReturnsSuccessMessage() {
                final var employeeAvailabilityController = new EmployeeAvailabilityController(employeeAvailabilityService);

                final var result = employeeAvailabilityController.insertEmployeeAvailability();

                Assertions.assertEquals("Inserted employee availability", result.getBody());
            }
        }
    }
}
