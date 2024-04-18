package by.task5.seminarTask5.controllers;

import by.task5.seminarTask5.model.Status;
import by.task5.seminarTask5.model.Task;
import by.task5.seminarTask5.repositories.TaskRepositories;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepositories taskRepositories;

    @GetMapping()
    public List<Task> findByAll(){
        return taskRepositories.findAll();
    }
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskRepositories.save(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status){
        return taskRepositories.findByStatus(status);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        if (task != null){
            int currentStatusNumber = task.getStatus().ordinal();
            if (task.getStatus() != Status.COMPLETED){
                currentStatusNumber++;
                task.setStatus(Status.values()[currentStatusNumber]);
            }
        }
        return taskRepositories.save(task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepositories.deleteById(id);
    }


}
