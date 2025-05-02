package org.example;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Todo> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }
}
