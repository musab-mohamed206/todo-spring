package com.test.todo.web;
 
import com.test.todo.domain.ProjectTask;
import com.test.todo.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin //to alow anather app to access the api
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    //@RequestMapping(method = RequestMethod.POST , value = "/todo")
    public ResponseEntity<?> addPTToBoard( @RequestBody ProjectTask projectTask ) {
        
        ProjectTask newPT = projectTaskService.saveOrUpdaProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPT , HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ProjectTask> getAllPTs() {
        return projectTaskService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTByID(@PathVariable Long pt_id) {
        ProjectTask projectTask = projectTaskService.findById(pt_id);
        return new ResponseEntity<ProjectTask>(projectTask , HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id) {
        projectTaskService.delete(pt_id);
        return new ResponseEntity<String>("Project Task deleted" , HttpStatus.OK);
    }
}
