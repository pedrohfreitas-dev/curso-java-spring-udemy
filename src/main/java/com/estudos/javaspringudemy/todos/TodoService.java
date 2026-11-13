package com.estudos.javaspringudemy.todos;


import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoValidator validator, MailSender mailSender, TodoRepository todoRepository) {
        this.validator = validator;
        this.mailSender = mailSender;
        this.todoRepository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return todoRepository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
         todoRepository.save(todo);
         String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
         mailSender.enviar("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return todoRepository.findById(id).orElseThrow(null);
    }

    public void deletar(Integer id) {
        todoRepository.deleteById(id);
    }
}
