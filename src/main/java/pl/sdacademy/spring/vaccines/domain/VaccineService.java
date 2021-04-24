package pl.sdacademy.spring.vaccines.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository repository;
    private final VaccineValidator validator;

    void addVaccine(PersonVaccineRequest request) {
        validator.validateVaccineRequest(request);
        Vaccine vaccine = VaccineMapper.mapToVaccine(request);
        repository.save(vaccine);
    }

    List<PersonVaccineResponse> findAll() {
        return repository.findAll()
            .stream()
            .map(VaccineMapper::mapToResponse)
            .collect(Collectors.toList());
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public PersonVaccineResponse getById(String id) {
        return repository
            .findById(id)
            .map(VaccineMapper::mapToResponse)
            .orElseThrow(() -> new PersonVaccineNotFoundException("Person with id: " + id + " doesn't exist"));
    }

    public void updateById(PersonVaccineRequest request) {
        Vaccine vaccine = repository
            .findById(request.getId())
            .orElseThrow(() -> new PersonVaccineNotFoundException("Person with id: " + request.getId() + " doesn't exist"));
        VaccineMapper.updateVaccine(vaccine, request);
        repository.save(vaccine);
    }
}
