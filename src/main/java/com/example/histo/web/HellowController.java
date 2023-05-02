package com.example.histo.web;

import com.example.histo.web.dto.HellowResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HellowResponseDto hellowResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HellowResponseDto(name, amount);
    }

}
