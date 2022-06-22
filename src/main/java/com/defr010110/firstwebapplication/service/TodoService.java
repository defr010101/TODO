package com.defr010110.firstwebapplication.service;

import com.defr010110.firstwebapplication.entity.TodoEntity;
import com.defr010110.firstwebapplication.entity.UserEntity;
import com.defr010110.firstwebapplication.exception.TodoNotFoundException;
import com.defr010110.firstwebapplication.exception.UserNotFoundException;
import com.defr010110.firstwebapplication.model.Todo;
import com.defr010110.firstwebapplication.repository.TodoRepo;
import com.defr010110.firstwebapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long user_id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(user_id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь с таким id не был найден");
        }

        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) throws TodoNotFoundException {
        TodoEntity todo = todoRepo.findById(id).get();
        if (todo == null) {
            throw new TodoNotFoundException("Задача с таким id не было найдено");
        }

        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
