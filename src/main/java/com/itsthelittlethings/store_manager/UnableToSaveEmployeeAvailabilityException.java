package com.itsthelittlethings.store_manager;

public class UnableToSaveEmployeeAvailabilityException extends RuntimeException{

    public UnableToSaveEmployeeAvailabilityException(String message) {
        super(message);
    }
}
