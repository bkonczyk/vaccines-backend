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

    @DeleteMapping("/czlowiek/{id}")
    public void delete(@PathVariable String id) {
        log.info("Received request to remove person with id {}", id);
        service.deleteById(id);
    }

    @GetMapping("/czlowiek/{id}")
    public PersonVaccineResponse get(@PathVariable String id) {
        log.info("Received request to get person with id {}", id);
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/czlowiek")
    public void updateVaccineRequest(@RequestBody PersonVaccineRequest request) {
        log.info("Received update request for a person id {}", request.getId());
        service.updateById(request);
    }
}
