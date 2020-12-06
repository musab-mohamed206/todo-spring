package com.test.todo.web;

import com.test.todo.service.ProjectTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@ReadingConverter
@RequestMapping("/api/todo")
@CrossOrigin //to alow anather app to access the api
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService projectTaskService;
}
