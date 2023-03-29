package com.example.demo.Exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public ApiError(HttpStatus status){
        this.status=status;
        this.timestamp=LocalDateTime.now();

    }
    public ApiError(HttpStatus status, String message, Throwable debugMessage) {
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage.getMessage();
        this.timestamp=LocalDateTime.now();

    }
}
