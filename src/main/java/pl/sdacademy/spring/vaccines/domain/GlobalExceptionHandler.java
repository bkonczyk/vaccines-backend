package pl.sdacademy.spring.vaccines.domain;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalError handleCustomException(CustomException customException) {
        return new GlobalError(customException.getMessage());
    }
}
