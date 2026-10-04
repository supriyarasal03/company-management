
package com.Ezio.ysAccdamy.department.dto;

public class DepartmentRequest {

    private String departmentName;
    private String description;
    private String location;

    public DepartmentRequest() {
    }

    public DepartmentRequest(String departmentName,
                             String description,
                             String location) {
        this.departmentName = departmentName;
        this.description = description;
        this.location = location;
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
