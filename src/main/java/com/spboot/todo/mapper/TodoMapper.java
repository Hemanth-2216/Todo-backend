package com.spboot.todo.mapper;

import com.spboot.todo.Dto.TodoDto;
import com.spboot.todo.entity.Todo;
import com.spboot.todo.entity.TodoId;
import com.spboot.todo.entity.User;

public class TodoMapper {

    public static TodoDto maptoTodoDto(Todo todo) {
        if (todo == null || todo.getId() == null) {
            throw new IllegalArgumentException("Todo or TodoId cannot be null");
        }

        return new TodoDto(
            todo.getId().getTaskId(),  // Extracting taskId from composite key
            todo.getId().getUserId(),  // Extracting userId from composite key
            todo.getTitle(),
            todo.getDescription(),
            todo.isCompleted()
        );
    }

    public static Todo maptoTodoEntity(Long userId, Long taskId, TodoDto tododto, User user) {
        if (tododto == null || user == null) {
            throw new IllegalArgumentException("TodoDto or User cannot be null");
        }

        return new Todo(
            new TodoId(userId, taskId),  // Setting composite key
            tododto.getTitle(),
            tododto.getDescription(),
            tododto.isCompleted(),
            user
        );
    }
}
