package com.itsthelittlethings.store_manager.controller;

import com.itsthelittlethings.store_manager.EmployeeAvailability;
import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import com.itsthelittlethings.store_manager.service.EmployeeAvailabilityService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class EmployeeAvailabilityControllerTest {

    @Mock
    private EmployeeAvailabilityService employeeAvailabilityService;

    private EmployeeAvailabilityController employeeAvailabilityController;
    private EmployeeAvailability employeeAvailability;

    @Nested
    @DisplayName("Given an employee wants to share their availability")
    class GivenAnEmployeeWantsToShareTheirAvailabilityTest {

        @BeforeEach
        void setUp() {
            employeeAvailabilityController = new EmployeeAvailabilityController(employeeAvailabilityService);
            employeeAvailability = new EmployeeAvailability();
        }

        @Nested
        @DisplayName("When an employee enters their availability for the first time")
        class WhenAnEmployeeEntersTheirAvailabilityForTheFirstTimeTest {

            @Nested
            @DisplayName("And the insert is successful")
            class AndTheInsertIsSuccessfulTest {
                @Test
                @DisplayName("Then insertEmployeeAvailability returns 200 OK status")
                void thenInsertEmployeeAvailabilityReturns200OkStatus() {
                    final var result = employeeAvailabilityController.insertEmployeeAvailability(employeeAvailability);

                    Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
                }

                @Test
                @DisplayName("Then insertEmployeeAvailability returns success message")
                void thenInsertEmployeeAvailabilityReturnsSuccessMessage() {
                    final var result = employeeAvailabilityController.insertEmployeeAvailability(employeeAvailability);

                    Assertions.assertEquals("Inserted employee availability", result.getBody());
                }
            }

            @Nested
            @DisplayName("And the insert is unable to save")
            class AndTheInsertIsUnableToSaveTest {

                @Test
                @DisplayName("Then insertEmployeeAvailability returns failed message")
                void thenInsertEmployeeAvailabilityReturnsFailedMessage() {
                    Mockito.doThrow(UnableToSaveEmployeeAvailabilityException.class).when(employeeAvailabilityService).saveAvailability(employeeAvailability);

                    final var result = employeeAvailabilityController.insertEmployeeAvailability(employeeAvailability);

                    Assertions.assertEquals("Unable to process request at this time", result.getBody());
                }

                @Test
                @DisplayName("Then insertEmployeeAvailability returns 500 Internal Server Error")
                void thenInsertEmployeeAvailabilityReturns500InternalServerError() {
                    Mockito.doThrow(UnableToSaveEmployeeAvailabilityException.class).when(employeeAvailabilityService).saveAvailability(employeeAvailability);

                    final var result = employeeAvailabilityController.insertEmployeeAvailability(employeeAvailability);

                    Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
                }
            }
        }
    }
}
