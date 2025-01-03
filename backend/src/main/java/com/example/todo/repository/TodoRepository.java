package com.example.todo.repository;

import com.example.todo.model.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
    Todo save(Todo todo);
    boolean existsById(Long id);
    void deleteById(Long id);
}
