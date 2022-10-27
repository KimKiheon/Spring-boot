package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    //http://localhost:8080/api/v1/get-api/hello
    public String hello(){
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName(){
        return "kiheon";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable+"hihi"; //페이지에 표시되는 내용
    }
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }
}
