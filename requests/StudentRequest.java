package com.example.demo.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String name;
    private String phone;
    private String address;
}
