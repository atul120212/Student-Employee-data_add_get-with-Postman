package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse extends BaseResponse {
    private int empId;
    private String empName;
    private String empPhone;
    private String empAddress;
    private float empSalary;
    private String empDesignation;
}
