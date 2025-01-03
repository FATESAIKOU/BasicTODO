package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTodos() {
        // Arrange
        List<Todo> todos = Arrays.asList(new Todo(), new Todo());
        when(todoRepository.findAll()).thenReturn(todos);

        // Act
        List<Todo> result = todoService.getAllTodos();

        // Assert
        assertEquals(todos, result);
        verify(todoRepository).findAll();
    }

    @Test
    void testSaveTodo() {
        // Arrange
        Todo todo = new Todo();
        when(todoRepository.save(todo)).thenReturn(todo);

        // Act
        Todo result = todoService.saveTodo(todo);

        // Assert
        assertEquals(todo, result);
        verify(todoRepository).save(todo);
    }

    @Test
    void testUpdateTodo() {
        // Arrange
        Long id = 1L;
        Todo updatedTodo = new Todo();
        when(todoRepository.existsById(id)).thenReturn(true);
        when(todoRepository.save(updatedTodo)).thenReturn(updatedTodo);

        // Act
        Optional<Todo> result = todoService.updateTodo(id, updatedTodo);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(updatedTodo, result.get());
        verify(todoRepository).existsById(id);
        verify(todoRepository).save(updatedTodo);
    }

    @Test
    void testDeleteTodo() {
        // Arrange
        Long id = 1L;
        when(todoRepository.existsById(id)).thenReturn(true);

        // Act
        boolean result = todoService.deleteTodo(id);

        // Assert
        assertTrue(result);
        verify(todoRepository).existsById(id);
        verify(todoRepository).deleteById(id);
    }
}
