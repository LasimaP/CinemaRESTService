package com.LP.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApiRequestException {

    @ExceptionHandler(UnknownSeatException.class)
    public ResponseEntity<Map<String,String>> seatOutOfBoundsException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "The number of a row or a column is out of bounds!"));
    }

    @ExceptionHandler(PurchasedException.class)
    public ResponseEntity<Map<String,String>> seatAlreadySoldException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "The ticket has been already purchased!"));

    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<Map<String, String>> wrongTokenException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Wrong token!"));
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<Map<String, String>> wrongPasswordException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "The password is wrong!"));
    }
}

