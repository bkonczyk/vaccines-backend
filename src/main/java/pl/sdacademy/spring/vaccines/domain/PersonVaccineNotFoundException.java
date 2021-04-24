package pl.sdacademy.spring.vaccines.domain;

public class PersonVaccineNotFoundException extends RuntimeException {

    public PersonVaccineNotFoundException(String message) {
        super(message);
    }
}
