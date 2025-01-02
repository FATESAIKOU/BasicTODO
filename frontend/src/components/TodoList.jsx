import React, { useEffect, useState } from 'react';

const TodoList = () => {
    const [todos, setTodos] = useState([]);
    const [title, setTitle] = useState('');
    
    useEffect(() => {
        fetch('/api/todos')
            .then(response => response.json())
            .then(data => setTodos(data));
    }, []);
    
    const addTodo = () => {
        const newTodo = { title, completed: false };
        fetch('/api/todos', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTodo),
        })
        .then(response => response.json())
        .then(data => {
            setTodos([...todos, data]);
            setTitle('');
        });
    };

    const updateTodo = (id) => {
        const updatedTodos = todos.map(todo => 
            todo.id === id ? { ...todo, completed: !todo.completed } : todo
        );
        setTodos(updatedTodos);
        fetch(`/api/todos/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ completed: !todos.find(todo => todo.id === id).completed }),
        });
    };

    const deleteTodo = (id) => {
        setTodos(todos.filter(todo => todo.id !== id));
        fetch(`/api/todos/${id}`, {
            method: 'DELETE',
        });
    };

    return (
        <div>
            <h1>Todo List</h1>
            <input 
                type="text" 
                value={title} 
                onChange={(e) => setTitle(e.target.value)} 
                placeholder="Add a new todo" 
            />
            <button onClick={addTodo}>Add</button>
            <ul>
                {todos.map(todo => (
                    <li key={todo.id}>
                        <span 
                            style={{ textDecoration: todo.completed ? 'line-through' : 'none' }} 
                            onClick={() => updateTodo(todo.id)}
                        >
                            {todo.title}
                        </span>
                        <button onClick={() => deleteTodo(todo.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;