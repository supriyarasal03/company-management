
package com.Ezio.ysAccdamy.department.service;

import com.Ezio.ysAccdamy.department.dto.DepartmentRequest;
import com.Ezio.ysAccdamy.department.dto.DepartmentResponse;
import com.Ezio.ysAccdamy.department.entity.Department;
import com.Ezio.ysAccdamy.department.repository.DepartmentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Create Department
    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        if (departmentRepository.existsByDepartmentNameIgnoreCase(
                request.getDepartmentName())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Department name already exists"
            );
        }

        Department department = new Department();

        department.setDepartmentName(request.getDepartmentName());
        department.setDescription(request.getDescription());
        department.setLocation(request.getLocation());

        Department savedDepartment =
                departmentRepository.save(department);

        return mapToResponse(savedDepartment);
    }

    // Get All Departments
    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get Department By ID
    @Override
    @Transactional(readOnly = true)
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = findDepartment(id);

        return mapToResponse(department);
    }

    // Update Department
    @Override
    public DepartmentResponse updateDepartment(
            Long id, DepartmentRequest request) {

        Department department = findDepartment(id);

        boolean nameChanged =
                !department.getDepartmentName()
                        .equalsIgnoreCase(request.getDepartmentName());

        if (nameChanged &&
                departmentRepository.existsByDepartmentNameIgnoreCase(
                        request.getDepartmentName())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Department name already exists"
            );
        }

        department.setDepartmentName(request.getDepartmentName());
        department.setDescription(request.getDescription());
        department.setLocation(request.getLocation());

        Department updatedDepartment =
                departmentRepository.save(department);

        return mapToResponse(updatedDepartment);
    }

    // Delete Department
    @Override
    public void deleteDepartment(Long id) {

        Department department = findDepartment(id);

        departmentRepository.delete(department);
    }

    // Find Department or Throw 404
    private Department findDepartment(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Department not found with ID: " + id
                        )
                );
    }

    // Convert Entity to Response DTO
    private DepartmentResponse mapToResponse(Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getLocation()
        );
    }
}
