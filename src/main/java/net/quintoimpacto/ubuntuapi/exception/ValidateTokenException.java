package net.quintoimpacto.ubuntuapi.exception;

public class ValidateTokenException extends RuntimeException {

    //Gestiona las excepciones relacionadas con la validación del token
    public ValidateTokenException(String message) {
        super(message);
    }
}