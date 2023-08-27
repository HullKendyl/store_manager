package controller;

import com.itsthelittlethings.store_manager.EmployeeAvailabilityController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class EmployeeAvailabilityTest {

    @Nested
    @DisplayName("Given an employee wants to share their availability")
    class GivenAnEmployeeWantsToShareTheirAvailabilityTest {

        @Nested
        @DisplayName("When an employee enters their availability for the first time")
        class WhenAnEmployeeEntersTheirAvailabilityForTheFirstTime {

            @Test
            @DisplayName("Then insertEmployeeAvailability returns 200 OK status")
            void thenInsertEmployeeAvailabilityReturns200OkStatus() {
                final var employeeAvailabilityController = new EmployeeAvailabilityController();

                final var result = employeeAvailabilityController.insertEmployeeAvailability();

                Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
            }

            @Test
            @DisplayName("Then insertEmployeeAvailability returns success message")
            void thenInsertEmployeeAvailabilityReturnsSuccessMessage() {
                final var employeeAvailabilityController = new EmployeeAvailabilityController();

                final var result = employeeAvailabilityController.insertEmployeeAvailability();

                Assertions.assertEquals("Inserted employee availability", result.getBody());
            }
        }
    }
}
