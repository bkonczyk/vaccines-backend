package pl.sdacademy.spring.vaccines.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public PersonVaccineResponse getById(String id) {
        return repository.findById(id).map(VaccineMapper::mapToResponse).orElse(null);
    }

    public void updateById(PersonVaccineRequest request) {
        Optional<Vaccine> byId = repository.findById(request.getId());
        if (byId.isEmpty()) {
            return;
        }
        Vaccine vaccine = byId.get();
        VaccineMapper.updateVaccine(vaccine, request);
        repository.save(vaccine);
    }
}
