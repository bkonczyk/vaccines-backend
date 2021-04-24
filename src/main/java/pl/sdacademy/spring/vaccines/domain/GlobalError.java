package pl.sdacademy.spring.vaccines.domain;

import java.time.LocalDateTime;

public class GlobalError {

    public String message;
    public final LocalDateTime time = LocalDateTime.now();

    public GlobalError(String message) {
        this.message = message;
    }
}
