import React, { useEffect, useState } from 'react';
import TodoList from './components/TodoList';

const App = () => {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        fetch('/api/todos')
            .then(response => response.json())
            .then(data => setTodos(data))
            .catch(error => console.error('Error fetching todos:', error));
    }, []);

    const addTodo = (title) => {
        const newTodo = { title, completed: false };
        fetch('/api/todos', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTodo),
        })
            .then(response => response.json())
            .then(data => setTodos([...todos, data]))
            .catch(error => console.error('Error adding todo:', error));
    };

    const updateTodo = (id, updatedTodo) => {
        fetch(`/api/todos/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updatedTodo),
        })
            .then(response => response.json())
            .then(data => {
                setTodos(todos.map(todo => (todo.id === id ? data : todo)));
            })
            .catch(error => console.error('Error updating todo:', error));
    };

    const deleteTodo = (id) => {
        fetch(`/api/todos/${id}`, {
            method: 'DELETE',
        })
            .then(() => {
                setTodos(todos.filter(todo => todo.id !== id));
            })
            .catch(error => console.error('Error deleting todo:', error));
    };

    return (
        <div>
            <h1>TODO Application</h1>
            <TodoList todos={todos} addTodo={addTodo} updateTodo={updateTodo} deleteTodo={deleteTodo} />
        </div>
    );
};

export default App;