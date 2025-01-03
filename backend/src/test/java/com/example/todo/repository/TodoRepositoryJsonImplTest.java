package com.example.todo.repository;

import com.example.todo.model.Todo;
import com.example.todo.repository.impl.TodoRepositoryJsonImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryJsonImplTest {

    private TodoRepositoryJsonImpl todoRepositoryJsonImpl;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        todoRepositoryJsonImpl = new TodoRepositoryJsonImpl();
    }

    // TODO: Fix the test cases
    // @Test
    // void testFindAll() throws Exception {
    //     // Arrange
    //     List<Todo> mockTodos = new ArrayList<>();
    //     Todo todo1 = new Todo();
    //     todo1.setId(1L);
    //     todo1.setTitle("Test Todo 1");
    //     Todo todo2 = new Todo();
    //     todo2.setId(2L);
    //     todo2.setTitle("Test Todo 2");
    //     mockTodos.add(todo1);
    //     mockTodos.add(todo2);
    //     String mockData = objectMapper.writeValueAsString(mockTodos);
    //     try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
    //         MockedStatic<Paths> mockedPaths = Mockito.mockStatic(Paths.class)) {
    //         mockedPaths.when(() -> Paths.get(anyString())).thenReturn(mock(Path.class));
    //         mockedFiles.when(() -> Files.readAllBytes(any(Path.class))).thenReturn(mockData.getBytes());

    //         // Act
    //         List<Todo> result = todoRepositoryJsonImpl.findAll();
    //         String resultJson = objectMapper.writeValueAsString(result);

    //         // Assert
    //         assertEquals(mockData, resultJson);
    //         mockedFiles.verify(() -> Files.readAllBytes(any(Path.class)));
    //     }
    // }

    // @Test
    // void testSave() throws Exception {
    //     // Arrange
    //     Todo newTodo = new Todo();
    //     newTodo.setTitle("New Todo");
    //     Todo existingTodo = new Todo();
    //     existingTodo.setId(1L);
    //     existingTodo.setTitle("Existing Todo");
    //     List<Todo> todos = new ArrayList<>();
    //     todos.add(existingTodo);
    //     String mockData = objectMapper.writeValueAsString(todos);
    //     try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
    //         MockedStatic<Paths> mockedPaths = Mockito.mockStatic(Paths.class)) {
    //         mockedPaths.when(() -> Paths.get(anyString())).thenReturn(mock(Path.class));
    //         mockedFiles.when(() -> Files.readAllBytes(any(Path.class))).thenReturn(mockData.getBytes());
    //         mockedFiles.when(() -> Files.write(any(Path.class), any(byte[].class))).thenReturn(null);

    //         // Act
    //         Todo savedNewTodo = todoRepositoryJsonImpl.save(newTodo);
    //         Todo savedExistingTodo = todoRepositoryJsonImpl.save(existingTodo);

    //         // Assert
    //         assertNotNull(savedNewTodo.getId());
    //         assertEquals("New Todo", savedNewTodo.getTitle());
    //         assertEquals(1L, savedExistingTodo.getId());
    //         assertEquals("Existing Todo", savedExistingTodo.getTitle());
    //         mockedFiles.verify(() -> Files.readAllBytes(any(Path.class)), times(2));
    //         mockedFiles.verify(() -> Files.write(any(Path.class), any(byte[].class)), times(2));
    //     }
    // }

    // @Test
    // void testExistsById() throws Exception {
    //     // Arrange
    //     Todo todo = new Todo();
    //     todo.setId(1L);
    //     List<Todo> todos = new ArrayList<>();
    //     todos.add(todo);
    //     String mockData = objectMapper.writeValueAsString(todos);
    //     try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
    //         MockedStatic<Paths> mockedPaths = Mockito.mockStatic(Paths.class)) {
    //         mockedPaths.when(() -> Paths.get(anyString())).thenReturn(mock(Path.class));
    //         mockedFiles.when(() -> Files.readAllBytes(any(Path.class))).thenReturn(mockData.getBytes());

    //         // Act
    //         boolean result = todoRepositoryJsonImpl.existsById(1L);

    //         // Assert
    //         assertTrue(result);
    //         mockedFiles.verify(() -> Files.readAllBytes(any(Path.class)));
    //     }
    // }

    // @Test
    // void testDeleteById() throws Exception {
    //     // Arrange
    //     Todo todo = new Todo();
    //     todo.setId(1L);
    //     List<Todo> todos = new ArrayList<>();
    //     todos.add(todo);
    //     String mockData = objectMapper.writeValueAsString(todos);
    //     try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
    //         MockedStatic<Paths> mockedPaths = Mockito.mockStatic(Paths.class)) {
    //         mockedPaths.when(() -> Paths.get(anyString())).thenReturn(mock(Path.class));
    //         mockedFiles.when(() -> Files.readAllBytes(any(Path.class))).thenReturn(mockData.getBytes());
    //         mockedFiles.when(() -> Files.write(any(Path.class), any(byte[].class))).thenReturn(null);

    //         // Act
    //         todoRepositoryJsonImpl.deleteById(1L);

    //         // Assert
    //         mockedFiles.verify(() -> Files.readAllBytes(any(Path.class)));
    //         mockedFiles.verify(() -> Files.write(any(Path.class), any(byte[].class)));
    //     }
    // }
}
