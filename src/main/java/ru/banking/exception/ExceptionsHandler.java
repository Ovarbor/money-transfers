package ru.banking.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionsHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    public void conflictException(ConflictException exception) {
        logger.error(exception.getMessage(), exception);
        new ErrorMessage(exception.getMessage());
    }

    public record ErrorMessage(String message) {
    }
}

