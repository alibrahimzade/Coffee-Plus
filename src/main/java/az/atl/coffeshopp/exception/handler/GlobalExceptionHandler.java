package az.atl.coffeshopp.exception.handler;

import az.atl.coffeshopp.exception.*;
import az.atl.coffeshopp.model.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchUserException.class)
    public ExceptionDto handle(NoSuchUserException exception) {
        log.error("not found: ", exception);
        return new ExceptionDto(NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ExceptionDto handle(UserAlreadyExistException exception) {
        log.error("already exist: ", exception);
        return new ExceptionDto(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(NoSuchPartnerException.class)
    public ExceptionDto handle(NoSuchPartnerException exception) {
        log.error("not found: ", exception);
        return new ExceptionDto(NOT_FOUND.value(), exception.getMessage());
    }
    @ExceptionHandler(PartnerAlreadyExistException.class)
    public ExceptionDto handle(PartnerAlreadyExistException exception) {
        log.error("not found: ", exception);
        return new ExceptionDto(NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(NoSuchFeatureException.class)
    public ExceptionDto handle(NoSuchFeatureException exception) {
        log.error("not found: ", exception);
        return new ExceptionDto(NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(FeatureAlreadyExist.class)
    public ExceptionDto handle(FeatureAlreadyExist exception) {
        log.error("not found: ", exception);
        return new ExceptionDto(NOT_FOUND.value(), exception.getMessage());
    }
}
