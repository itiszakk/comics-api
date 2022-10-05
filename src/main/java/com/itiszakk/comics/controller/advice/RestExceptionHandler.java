package com.itiszakk.comics.controller.advice;

import com.itiszakk.comics.exception.*;
import com.itiszakk.comics.exception.CharacterAlreadyExistsException;
import com.itiszakk.comics.exception.CharacterDTOException;
import com.itiszakk.comics.exception.CharacterFieldReferenceException;
import com.itiszakk.comics.exception.CharacterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<ErrorResponse> characterNotFoundExceptionHandler(CharacterNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(value = CharacterDTOException.class)
    public ResponseEntity<ErrorResponse> characterDTOExceptionHandler(CharacterDTOException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(value = CharacterAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> characterAlreadyExistsExceptionHandler(CharacterAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, e.getMessage()));
    }

    @ExceptionHandler(value = RequestParameterValueException.class)
    public ResponseEntity<ErrorResponse> requestParameterValueExceptionHandler(RequestParameterValueException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(value = CharacterFieldReferenceException.class)
    public ResponseEntity<ErrorResponse> characterFieldReferenceExceptionHandler(CharacterFieldReferenceException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}
