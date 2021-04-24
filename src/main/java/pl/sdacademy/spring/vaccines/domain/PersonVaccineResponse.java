package pl.sdacademy.spring.vaccines.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonVaccineResponse {

    String id;
    String imie;
    String nazwisko;
    String plec;
    String komentarze;
    Short typ;
    ExtraWishesResponse zyczenia;


//    {"id":"Bartek",
//    "imie":"Bartek",
//    "nazwisko":"Nowak",
//    "plec":"m",
//    "komentarze":"chcialbym byc piosenkarzem",
//    "typ":1,
//    "zyczenia":{"a":true,"b":true}}
}
