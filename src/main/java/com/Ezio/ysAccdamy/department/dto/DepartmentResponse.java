
package com.Ezio.ysAccdamy.department.dto;

public class DepartmentResponse {

    private Long id;
    private String departmentName;
    private String description;
    private String location;

    public DepartmentResponse() {
    }

    public DepartmentResponse(Long id, String departmentName,
                              String description, String location) {
        this.id = id;
        this.departmentName = departmentName;
        this.description = description;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
