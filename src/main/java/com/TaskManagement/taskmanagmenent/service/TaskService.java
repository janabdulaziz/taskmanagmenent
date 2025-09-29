package com.TaskManagement.taskmanagmenent.service;

import com.TaskManagement.taskmanagmenent.dto.TaskDTO;
import com.TaskManagement.taskmanagmenent.model.Task;
import com.TaskManagement.taskmanagmenent.repository.TaskRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> searchByTitle(String title) {
        return taskRepository.findByTitleContaining(title);
    }


    public Task updateTask(Integer id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }


    public List<TaskDTO> getAllTaskDTOs() {
        return taskRepository.findAll()
                .stream()
                .map(TaskDTO::toDto)
                .collect(Collectors.toList());
    }



    public Page<Task> TasksWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return taskRepository.findAll(pageable);
    }

    public List<Task> findBycompleted(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }



}
