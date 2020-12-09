package com.test.todo.service;

import com.test.todo.domain.ProjectTask;
import com.test.todo.repository.ProjectTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdaProjectTask(ProjectTask projectTask) {
        if (projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }
}
