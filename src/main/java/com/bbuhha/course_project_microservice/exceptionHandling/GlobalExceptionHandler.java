package com.bbuhha.course_project_microservice.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<IncorrectData> handleExceptionNotFound(
            //В случае выбрасывания NoSuchException мы должны добавить в тело Response добавить объект IncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            NoSuchException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<IncorrectData> handleExceptionAny(
            //В случае выбрасывания любой ошибка мы должны добавить в тело Response добавить объект IncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            Exception exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
