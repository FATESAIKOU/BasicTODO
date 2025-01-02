package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final String filePath = System.getenv().getOrDefault("TODO_FILE_PATH", "src/main/resources/todos.json");

    public List<Todo> getAllTodos() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return parseTodos(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Todo saveTodo(Todo todo) {
        List<Todo> todos = getAllTodos();
        todos.add(todo);
        writeTodos(todos);
        return todo;
    }

    public Optional<Todo> updateTodo(Long id, Todo updatedTodo) {
        List<Todo> todos = getAllTodos();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id)) {
                todos.set(i, updatedTodo);
                writeTodos(todos);
                return Optional.of(updatedTodo);
            }
        }
        return Optional.empty();
    }

    public boolean deleteTodo(Long id) {
        List<Todo> todos = getAllTodos();
        boolean removed = todos.removeIf(todo -> todo.getId().equals(id));
        if (removed) {
            writeTodos(todos);
        }
        return removed;
    }

    private List<Todo> parseTodos(String content) {
        // Implement JSON parsing logic to convert content to List<Todo>
        return new ArrayList<>(); // Placeholder
    }

    private void writeTodos(List<Todo> todos) {
        // Implement logic to convert List<Todo> to JSON and write to file
    }
}