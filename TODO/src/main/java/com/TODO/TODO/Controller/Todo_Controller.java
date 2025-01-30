package com.TODO.TODO.Controller;

import com.TODO.TODO.Entity.Task;
import com.TODO.TODO.Repository.Todo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class Todo_Controller
{

    @Autowired
    private Todo_Repository todoRepository;

    @GetMapping
    public List<Task> getTasks()
    {
        return todoRepository.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task)
    {
        return todoRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        todoRepository.deleteById(id);
    }
}
