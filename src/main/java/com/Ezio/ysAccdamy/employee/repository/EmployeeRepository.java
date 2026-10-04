
package com.Ezio.ysAccdamy.employee.repository;

import com.Ezio.ysAccdamy.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
