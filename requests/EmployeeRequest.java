package com.example.demo.requests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String empName;
    private String empPhone;
    private String empAddress;
    private float empSalary;
    private String empDesignation;
}
