package pl.sdacademy.spring.vaccines.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalError handleCustomException(CustomException customException) {
        log.error("Handling custom exception");
        return new GlobalError(customException.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalError handlePersonNotFoundException(PersonVaccineNotFoundException e) {
        return new GlobalError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalError handleArgumentException(MethodArgumentNotValidException e) {
        String message =
            e.getFieldError() != null ? e.getFieldError().getDefaultMessage() : "Invalid argument";
        return new GlobalError(message);
    }


}
//exception.getFieldError().getDefaultMessage()
