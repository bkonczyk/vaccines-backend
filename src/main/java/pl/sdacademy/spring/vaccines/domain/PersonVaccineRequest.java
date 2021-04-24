package pl.sdacademy.spring.vaccines.domain;

import lombok.Value;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Value
@Accessors(chain = true)
public class PersonVaccineRequest {

    String id;
    String imie;
//    @NotEmpty(message = "Surname should not be empty")
    String nazwisko;
    String plec;
    String komentarze;
    Short typ;
    ExtraWishesRequest zyczenia;
}
