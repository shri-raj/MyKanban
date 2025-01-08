package com.example.MyKanban;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    void deleteTask(Long id);
    Optional<Task> updateTaskState(Long id, String newState);
}
