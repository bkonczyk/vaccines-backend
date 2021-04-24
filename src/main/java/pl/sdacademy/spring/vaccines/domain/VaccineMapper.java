package pl.sdacademy.spring.vaccines.domain;

public class VaccineMapper {

    static Vaccine mapToVaccine(PersonVaccineRequest request) {
        return new Vaccine()
            .setId(request.getId())
            .setName(request.getImie())
            .setSurname(request.getNazwisko())
            .setComments(request.getKomentarze())
            .setSex(request.getPlec())
            .setType(request.getTyp())
            .setFirstWish(request.getZyczenia().isA())
            .setSecondWish(request.getZyczenia().isB());
    }

    static PersonVaccineResponse mapToResponse(Vaccine vaccine) {
        return new PersonVaccineResponse()
            .setId(vaccine.getId())
            .setImie(vaccine.getName())
            .setNazwisko(vaccine.getSurname())
            .setKomentarze(vaccine.getComments())
            .setPlec(vaccine.getSex())
            .setTyp(vaccine.getType())
            .setZyczenia(new ExtraWishesResponse(vaccine.isFirstWish(), vaccine.isSecondWish()));
    }

    static void updateVaccine(Vaccine vaccine, PersonVaccineRequest request) {
        vaccine.setName(request.getImie());
        vaccine.setSurname(request.getNazwisko());
        vaccine.setComments(request.getKomentarze());
        vaccine.setSex(request.getPlec());
        vaccine.setType(request.getTyp());
        vaccine.setFirstWish(request.getZyczenia().isA());
        vaccine.setSecondWish(request.getZyczenia().isB());
    }
}
