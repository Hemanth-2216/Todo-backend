package com.spboot.todo.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoApiException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
