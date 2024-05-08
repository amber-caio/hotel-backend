package com.caioamber.hotel.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<Object> handleIllegalArgumentException(Exception e){
        Map<String, Object> body = new HashMap<>();

        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
