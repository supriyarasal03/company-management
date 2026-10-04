
package com.Ezio.ysAccdamy.employee.ServiceImpl;

import com.Ezio.ysAccdamy.employee.dto.EmployeeRequest;
import com.Ezio.ysAccdamy.employee.dto.EmployeeResponse;
import com.Ezio.ysAccdamy.employee.entity.Employee;
import com.Ezio.ysAccdamy.employee.repository.EmployeeRepository;

import com.Ezio.ysAccdamy.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE EMPLOYEE
    @Override
    public EmployeeResponse createEmployee(
            EmployeeRequest request) {

        Employee employee = new Employee(
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getMobileNumber()
        );

        Employee savedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(savedEmployee);
    }

    // GET ALL EMPLOYEES
    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET EMPLOYEE BY ID
    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found with ID: " + id
                ));

        return mapToResponse(employee);
    }

    // UPDATE EMPLOYEE
    @Override
    public EmployeeResponse updateEmployee(
            Long id,
            EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found with ID: " + id
                ));

        employee.setName(request.getName());
        employee.setAddress(request.getAddress());
        employee.setEmail(request.getEmail());
        employee.setMobileNumber(request.getMobileNumber());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(updatedEmployee);
    }

    // DELETE EMPLOYEE
    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employee not found with ID: " + id
            );
        }

        employeeRepository.deleteById(id);
    }

    // ENTITY TO RESPONSE DTO
    private EmployeeResponse mapToResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getMobileNumber()
        );
    }
}
