package com.fly.test.controller;

import com.fly.test.entity.Subject;
import com.fly.test.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
@Api(value = "Subject", tags = "主题")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    @ApiOperation("列表查询")
    public List<Subject> list() {
        return subjectService.list();
    }

}
