package fr.eni.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String>capturerException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    };

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<String>capturerException(MethodArgumentNotValidException e){

        String message = e.getFieldErrors()
                .stream()
                .map(f -> f.getField() + " : " + f.getDefaultMessage())
                .collect(Collectors.joining(" - "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    };


}
