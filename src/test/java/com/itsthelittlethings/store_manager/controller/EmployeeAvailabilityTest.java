package com.itsthelittlethings.store_manager.controller;

import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import com.itsthelittlethings.store_manager.controller.EmployeeAvailabilityController;
import com.itsthelittlethings.store_manager.service.EmployeeAvailabilityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

            @Nested
            @DisplayName("And the insert is successful")
            class AndTheInsertIsSuccessfulTest {
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

            @Nested
            @DisplayName("And the insert is unable to save")
            class AndTheInsertIsUnableToSaveTest {

                @Test
                @DisplayName("Then insertEmployeeAvailability returns failed message")
                void thenInsertEmployeeAvailabilityReturnsFailedMessage() {
                    final var employeeAvailabilityController = new EmployeeAvailabilityController(employeeAvailabilityService);
                    Mockito.doThrow(UnableToSaveEmployeeAvailabilityException.class).when(employeeAvailabilityService).saveAvailability();

                    final var result = employeeAvailabilityController.insertEmployeeAvailability();

                    Assertions.assertEquals("Unable to process request at this time", result.getBody());
                }

            }
        }
    }
}
