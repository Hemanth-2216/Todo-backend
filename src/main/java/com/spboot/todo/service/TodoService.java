package com.spboot.todo.service;

import java.util.List;
import com.spboot.todo.Dto.TodoDto;

public interface TodoService {
    TodoDto addTask(Long userId, TodoDto todoDto);  // Require userId
    TodoDto updateTask(Long userId, Long taskId, TodoDto todoUpdate);
    void deleteTask(Long userId, Long taskId);
    List<TodoDto> getAllTasks(Long userId);  // Get tasks only for logged-in user
    TodoDto getTaskById(Long userId, Long taskId);
	TodoDto updateTaskStatus(Long userId, Long taskId, boolean completed);
}
