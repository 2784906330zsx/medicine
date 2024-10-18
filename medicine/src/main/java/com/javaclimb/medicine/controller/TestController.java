package com.javaclimb.medicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/testString")
    @ResponseBody
    public String testString(){
        return "hello";
    }
}
