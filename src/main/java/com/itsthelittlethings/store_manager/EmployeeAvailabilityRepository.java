package com.itsthelittlethings.store_manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {
}
