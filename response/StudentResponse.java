package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse extends BaseResponse {
    private int rollNo;
    private String name;
    private String phone;
    private String address;
}
