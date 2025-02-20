package com.fly.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    public @ResponseBody ResponseEntity test() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("success");
    }

}
