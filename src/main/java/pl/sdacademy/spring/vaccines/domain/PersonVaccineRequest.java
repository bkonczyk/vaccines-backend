package pl.sdacademy.spring.vaccines.domain;

import lombok.Value;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Value
@Accessors(chain = true)
public class PersonVaccineRequest {

    String id;
    String imie;

    @NotEmpty(message = "Surname should not be empty")
    String nazwisko;
    String plec;
    @Length(min = 1, max = 150, message = "Komentarze should be between 1 and 150")
    String komentarze;
    Short typ;
    ExtraWishesRequest zyczenia;
}
