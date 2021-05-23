package com.nweligalla.classman.repository;

import com.nweligalla.classman.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //spring automatically created the method by figuring out the method name
    void deleteById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
