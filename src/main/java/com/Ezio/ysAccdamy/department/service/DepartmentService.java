
package com.Ezio.ysAccdamy.department.service;

import com.Ezio.ysAccdamy.department.dto.DepartmentRequest;
import com.Ezio.ysAccdamy.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse updateDepartment(Long id,
                                        DepartmentRequest request);

    void deleteDepartment(Long id);
}
