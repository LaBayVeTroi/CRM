package com.example.task.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMutation implements GraphQLMutationResolver {
    @Autowired
    private TaskService taskService;

    public Task addNewTask(Task task){
        return taskService.addTask(task);
    }
}
