package pl.sdacademy.spring.vaccines.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class VaccineController {

    private final VaccineService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/czlowiek")
    public void addVaccine(@RequestBody @Valid PersonVaccineRequest request) {
        log.info("Received request to save vaccine for {}", request.getImie());
        service.addVaccine(request);
    }

    @GetMapping("/ludzie")
    public List<PersonVaccineResponse> findAll() {
        log.info("Received request to find all people");
        return service.findAll();
    }

    //1. Stworzyc DTO VaccineResponse
    //2. Metoda serwisowa, ktora zwroci listę VaccineResponse + mapowanie
    //3. Wystawić endpoint pod URL "/ludzie"
}
