package org.itiszakk.comics.character.controller;

import org.itiszakk.comics.controller.ErrorResponse;
import org.itiszakk.comics.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CharacterRestControllerAdvice {

    @ExceptionHandler(value = CharacterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse characterNotFoundExceptionHandler(CharacterNotFoundException e) {
        return response(e);
    }

    @ExceptionHandler(value = CharacterDTOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse characterDTOExceptionHandler(CharacterDTOException e) {
        return response(e);
    }

    @ExceptionHandler(value = CharacterAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse characterAlreadyExistsExceptionHandler(CharacterAlreadyExistsException e) {
        return response(e);
    }

    @ExceptionHandler(value = RequestParameterValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse requestParameterValueExceptionHandler(RequestParameterValueException e) {
        return response(e);
    }

    @ExceptionHandler(value = CharacterFieldReferenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse characterFieldReferenceExceptionHandler(CharacterFieldReferenceException e) {
        return response(e);
    }

    private ErrorResponse response(Exception exception) {
        return new ErrorResponse(exception.getMessage());
    }
}