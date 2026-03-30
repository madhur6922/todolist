package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    // CREATE
    @PostMapping("/todos")
    public Todo create(@RequestBody Todo t) {
        return service.add(t);
    }

    // READ ALL
    @GetMapping("/todos")
    public List<Todo> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/todo/{id}")
    public Todo get(@PathVariable Integer id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/todo/{id}")
    public Todo update(@PathVariable Integer id, @RequestBody Todo t) {
        return service.update(id, t);
    }

    // DELETE
    @DeleteMapping("/todos/{id}")
    public String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
