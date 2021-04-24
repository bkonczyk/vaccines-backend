package pl.sdacademy.spring.vaccines.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public GlobalError handleCustomException(CustomException customException) {
        log.error("Handling custom exception");
        return new GlobalError(customException.getMessage());
    }

    @ExceptionHandler
    public GlobalError handlePersonNotFoundException(PersonVaccineNotFoundException e) {
        return new GlobalError(e.getMessage());
    }
}
