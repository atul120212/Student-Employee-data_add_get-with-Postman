package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.requests.EmployeeRequest;
import com.example.demo.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = mapEmployeeRequestToEmployee(employeeRequest);
        employee = employeeRepository.save(employee);
        EmployeeResponse employeeResponse = mapEmployeeRequestToEmployeeResponse(employee);
        return employeeResponse;
    }



    private Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmpAddress(employeeRequest.getEmpAddress());
        employee.setEmpName(employeeRequest.getEmpName());
        employee.setEmpPhone(employeeRequest.getEmpPhone());
        return employee;
    }

    private EmployeeResponse mapEmployeeRequestToEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpPhone(employee.getEmpPhone());
        employeeResponse.setEmpAddress(employee.getEmpAddress());
        employeeResponse.setEmpId(employee.getEmpId());
        employeeResponse.setEmpName(employee.getEmpName());
        employeeResponse.setCode(HttpStatus.CREATED.value());
        employeeResponse.setStatus(HttpStatus.CREATED.name());
        return employeeResponse;
    }

    @GetMapping("/get")
    public EmployeeResponse getEmployee(@RequestParam int empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        EmployeeResponse employeeResponse = mapEmployeeRequestToEmployeeResponse(employee.get());
        return employeeResponse;
    }
}


