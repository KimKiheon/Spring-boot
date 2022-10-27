package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            System.out.printf("key:%s value:%s",map.getKey(),map.getValue());
            //sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        //return sb.toString();
        return "request2 호출 완료";
    }

}
