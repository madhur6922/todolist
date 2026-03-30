package com.example.demo.service;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> list = new ArrayList<>();

    // CREATE
    public Todo add(Todo t) {
        list.add(t);
        return t;
    }

    // READ ALL
    public List<Todo> getAll() {
        return list;
    }

    // READ BY ID
    public Todo getById(Integer id) {
        for (Todo t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    // UPDATE
    public Todo update(Integer id, Todo newTodo) {
        for (Todo t : list) {
            if (t.getId().equals(id)) {
                t.setTitle(newTodo.getTitle());
                t.setDescription(newTodo.getDescription());
                t.setStatus(newTodo.isStatus());
                return t;
            }
        }
        return null;
    }

    // DELETE
    public String delete(Integer id) {
        list.removeIf(t -> t.getId().equals(id));
        return "Deleted";
    }
}
