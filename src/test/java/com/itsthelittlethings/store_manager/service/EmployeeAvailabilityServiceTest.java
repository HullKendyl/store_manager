package com.itsthelittlethings.store_manager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class EmployeeAvailabilityServiceTest {

    @Nested
    @DisplayName("Given employee availability is submitted")
    class GivenEmployeeAvailabilityIsSubmittedTest {

        @Nested
        @DisplayName("When the availability is saved to the database")
        class WhenTheAvailabilityIsSavedToTheDatabaseTest {

            @Test
            @DisplayName("Then saveAvailability returns a success message")
            void thenSaveAvailabilityReturnsSuccessMessage() {
                final var employeeAvailabilityService = new EmployeeAvailabilityService();

                final var result = employeeAvailabilityService.saveAvailability();

                Assertions.assertEquals("", result);
            }
        }
    }

}
