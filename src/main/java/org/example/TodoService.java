package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List findAll() {
        return repository.findAll();
    }

    public Todo findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Todo toggleTodo(String id) {
        Todo todo = this.findById(id);
        todo.setDone(!todo.isDone());
        return repository.save(todo);
    }
}