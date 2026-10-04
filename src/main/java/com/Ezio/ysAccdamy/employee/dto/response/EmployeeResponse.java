
package com.Ezio.ysAccdamy.employee.dto;

public class EmployeeResponse {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String mobileNumber;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long id, String name,
                            String address, String email,
                            String mobileNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
