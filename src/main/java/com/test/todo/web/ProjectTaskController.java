package com.test.todo.web;

import com.test.todo.domain.ProjectTask;
import com.test.todo.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin //to alow anather app to access the api
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    //@RequestMapping(method = RequestMethod.POST , value = "/todo")
    public ResponseEntity<?> addPTToBoard(@RequestBody ProjectTask projectTask) {
        ProjectTask newPT = projectTaskService.saveOrUpdaProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT , HttpStatus.CREATED);
    }
}
