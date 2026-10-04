
package com.Ezio.ysAccdamy.employee.service;

import com.Ezio.ysAccdamy.employee.dto.EmployeeRequest;
import com.Ezio.ysAccdamy.employee.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(
            Long id,
            EmployeeRequest request
    );

    void deleteEmployee(Long id);
}
