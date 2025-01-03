package com.example.todo.repository.impl;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryJsonImpl implements TodoRepository {

    @Value("${service.data-file-path}")
    private String dataFilePath;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Todo> findAll() {
        try {
            String content = new String(Files.readAllBytes(getDataFilePath()));
            return objectMapper.readValue(content, new TypeReference<List<Todo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Todo save(Todo todo) {
        List<Todo> todos = findAll();
        todos.add(todo);
        writeTodos(todos);
        return todo;
    }

    @Override
    public boolean existsById(Long id) {
        return findAll().stream().anyMatch(todo -> todo.getId().equals(id));
    }

    @Override
    public void deleteById(Long id) {
        List<Todo> todos = findAll();
        todos.removeIf(todo -> todo.getId().equals(id));
        writeTodos(todos);
    }

    private void writeTodos(List<Todo> todos) {
        try {
            String content = objectMapper.writeValueAsString(todos);
            Files.write(getDataFilePath(), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path getDataFilePath() {
        return Paths.get(dataFilePath);
    }
}
