package com.fly.test.controller;

import com.fly.test.entity.Subject;
import com.fly.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public List<Subject> list() {
        return subjectService.list();
    }

}
