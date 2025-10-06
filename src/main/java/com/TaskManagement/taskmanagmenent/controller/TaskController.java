package com.TaskManagement.taskmanagmenent.controller;
import com.TaskManagement.taskmanagmenent.dto.TaskDTO;
import com.TaskManagement.taskmanagmenent.model.Task;
import com.TaskManagement.taskmanagmenent.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public  TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/search")
    public List<Task> search(@RequestParam String title) {
        return taskService.searchByTitle(title);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {

        return taskService.updateTask(id, task);

    }

    @GetMapping("/dto")
    public List<TaskDTO> getTasksAsDTO() {
        return taskService.getAllTaskDTOs();
    }




    @GetMapping("/paged")
    public Page<Task> getPagedTasks(@RequestParam int page, @RequestParam int size) {
        return taskService.TasksWithPagination(page, size);
    }

    @GetMapping("/filter")
    public List<Task> filterTasks(@RequestParam boolean completed) {
        return taskService.findBycompleted(completed);

    }



}
