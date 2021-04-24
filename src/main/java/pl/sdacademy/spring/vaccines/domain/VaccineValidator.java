package pl.sdacademy.spring.vaccines.domain;

import org.springframework.stereotype.Component;

@Component
public class VaccineValidator {

    public void validateVaccineRequest(PersonVaccineRequest request) {
        if (request.getNazwisko() == null || request.getNazwisko().isEmpty()) {
            throw new CustomException("Surname cannot be empty");
        }
    }
}
