package com.example.MyKanban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> updateTaskState(Long id, String newState) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            try {
                TaskState newStateEnum = TaskState.valueOf(newState.toUpperCase());
                task.setState(newStateEnum);
                taskRepository.save(task);
                return Optional.of(task);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid task state: " + newState +
                        ". Valid states are: " + Arrays.toString(TaskState.values()));
            }
        }
        return Optional.empty();
    }

}

//public TaskState state (String s){
//    if(s=="To Do") state = To_Do;
//    else if(s=="In Progress") ;
//    else if(s=="Completed") ;
//    else
//    return ans;
//}