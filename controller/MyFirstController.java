package com.example.demo.controller;


import com.example.demo.requests.MyFirstRequest;
import com.example.demo.response.MyFirstResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyFirstController {

    private int id = 1;

    @GetMapping("/raam")
    public String first() {
        return "Hello Java";
    }

    @PostMapping("/atul")
    public MyFirstResponse myData(@RequestBody MyFirstRequest myFirstRequest) {
        MyFirstResponse myFirstResponse = requestToResponse(myFirstRequest);
        return myFirstResponse;
    }

    private MyFirstResponse requestToResponse(MyFirstRequest myFirstRequest) {
        MyFirstResponse myFirstResponse = new MyFirstResponse();
        myFirstResponse.setId(id);
        myFirstResponse.setComment(myFirstRequest.getName() + " " + myFirstRequest.getRoll());
        id++;
        return myFirstResponse;
    }

}
