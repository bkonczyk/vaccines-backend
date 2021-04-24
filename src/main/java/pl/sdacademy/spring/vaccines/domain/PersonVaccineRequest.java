package pl.sdacademy.spring.vaccines.domain;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(chain = true)
public class PersonVaccineRequest {

    String id;
    String imie;
    String nazwisko;
    String plec;
    String komentarze;
    Short typ;
    ExtraWishesRequest zyczenia;


//    {"id":"Bartek",
//    "imie":"Bartek",
//    "nazwisko":"Nowak",
//    "plec":"m",
//    "komentarze":"chcialbym byc piosenkarzem",
//    "typ":1,
//    "zyczenia":{"a":true,"b":true}}
}
