package com.example.technologiesieciowelista1.controllers;
import com.example.technologiesieciowelista1.exception.UserAlreadyExistsException;
import com.example.technologiesieciowelista1.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleUserNotFoundException(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
