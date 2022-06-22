package com.defr010110.firstwebapplication.controller;

import com.defr010110.firstwebapplication.entity.TodoEntity;
import com.defr010110.firstwebapplication.exception.TodoNotFoundException;
import com.defr010110.firstwebapplication.exception.UserNotFoundException;
import com.defr010110.firstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long user_id) {
        try {
            todoService.createTodo(todo, user_id);
            return ResponseEntity.ok().body("Задача успешно добавлена");
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            todoService.completeTodo(id);
            return ResponseEntity.ok().body("Флаг задачи сменен");
        } catch (TodoNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
