package com.estudos.javaspringudemy.todos;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return todoService.salvar(todo);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable Integer id ,@RequestBody TodoEntity todo) {
        todo.setId(id);
         todoService.atualizarStatus(todo);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id) {
        todoService.deletar(id);
    }
}
