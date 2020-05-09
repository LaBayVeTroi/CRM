package com.example.task.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskQuery implements GraphQLQueryResolver {
    @Autowired
    private TaskService taskService;

    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }
}
