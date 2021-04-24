package pl.sdacademy.spring.vaccines.domain;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
