package pl.sdacademy.spring.vaccines.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository repository;

    void addVaccine(PersonVaccineRequest request) {
        Vaccine vaccine = VaccineMapper.mapToVaccine(request);
        repository.save(vaccine);
    }

    List<PersonVaccineResponse> findAll() {
        return repository.findAll()
            .stream()
            .map(VaccineMapper::mapToResponse)
            .collect(Collectors.toList());
    }
}
