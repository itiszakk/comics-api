package org.itiszakk.comics.exception;

public class RequestParameterValueException extends RuntimeException {

    public RequestParameterValueException(String parameter, String value) {
        super(String.format("Unsupported value '%s' of parameter '%s'", value, parameter));
    }
}
