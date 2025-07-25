package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository {
    List<Patient> patients = new ArrayList<>();
    private static final PatientRepository instance = new PatientRepository();

    private PatientRepository() {
    }

    public static PatientRepository getInstance() {
        return instance;
    }

    public void save(Patient patient) {
        // 생성(Create) 와 수정(Update) 가 같은 save 메서드를 사용. (JPA 에서는 PK 값 확인해서 알아서 수정또는저장해줌)

        Optional<Patient> existing = findById(patient.getId());
        existing.ifPresent(value -> this.delete(value)); // 1. 해당환자가 존재하면 저장소에서 해당 환자를 삭제해라
        //existing.ifPresent(this::delete); // this == PatientRepository
        patients.add(patient); // 2. 그리고 추가해라
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients); // 읽기 전용
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void delete(Patient patient) {
        patients.remove(patient);
    }
}
