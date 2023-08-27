package com.itsthelittlethings.store_manager.service;

import com.itsthelittlethings.store_manager.EmployeeAvailability;
import com.itsthelittlethings.store_manager.EmployeeAvailabilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeAvailabilityServiceTest {

    @Mock
    private EmployeeAvailabilityRepository employeeAvailabilityRepository;

    @Nested
    @DisplayName("Given employee availability is submitted")
    class GivenEmployeeAvailabilityIsSubmittedTest {

        @Nested
        @DisplayName("When the availability is saved to the database")
        class WhenTheAvailabilityIsSavedToTheDatabaseTest {

            @Test
            @DisplayName("Then saveAvailability returns a success message")
            void thenSaveAvailabilityReturnsSuccessMessage() {
                final var employeeAvailabilityService = new EmployeeAvailabilityService(employeeAvailabilityRepository);
                final var employeeAvailability = new EmployeeAvailability();

                final var result = employeeAvailabilityService.saveAvailability(employeeAvailability);

                Assertions.assertEquals("Successfully saved employee availability", result);
            }
        }
    }

}
