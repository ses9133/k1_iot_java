package org.example.z_project.phr_solution.service.implement;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.entity.HealthRecord;
import org.example.z_project.phr_solution.entity.Patient;
import org.example.z_project.phr_solution.repository.HealthRecordRepository;
import org.example.z_project.phr_solution.repository.PatientRepository;
import org.example.z_project.phr_solution.service.HealthRecordService;
import org.example.z_project.phr_solution.util.DateValidator;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HealthRecordServiceImpl implements HealthRecordService {

    private final HealthRecordRepository recordRepository;
    private final PatientRepository patientRepository;

    private static Long currentId = 1L;

    public HealthRecordServiceImpl() {
        this.recordRepository = HealthRecordRepository.getInstance();
        this.patientRepository = PatientRepository.getInstance();
    }

    private Long generatedRecordId() {
        return currentId++;
    }

//    private RecordListResponseDto toDto(HealthRecord r) {
//        return new RecordListResponseDto(
//                r.getId(),
//                r.getPatientId(),
//                r.getDateOfVisit(),
//                r.getDiagnosis(),
//                r.getTreatment(),
//                new Date() // 조회 시간
//        );
//    }

    // 환자 고유 ID 유효성 입증하는 메서드
    private void validatePatientId(Long patientId) {
        // 환자 존재 여부 확인
        Optional<Patient> foundPatient = patientRepository.findById(patientId);

        if(foundPatient.isEmpty()) {
            throw new IllegalArgumentException("해당 ID 의 환자를 찾을 수 없습니다.:" + patientId);
        }
    }

    @Override
    public void createdRecord(RecordCreateRequestDto dto) {
            try {
                validatePatientId(dto.getPatientId());

                // 날짜 형식 유효성 검사
                DateValidator.validateOrThrow(dto.getDateOfVisit());

                HealthRecord record = new HealthRecord(generatedRecordId(),
                        dto.getPatientId(), dto.getDateOfVisit(), dto.getDiagnosis(), dto.getTreatment());

                recordRepository.save(record);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public List<RecordListResponseDto> getAllRecords() {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();
            dtos = records.stream()
                    .map(rec -> new RecordListResponseDto(
                            rec.getId(), rec.getPatientId(), rec.getDateOfVisit(), rec.getDiagnosis(),
                            rec.getTreatment(), new Date()
                    )).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dtos;
    }

    @Override
    public List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis) {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();
            dtos = records.stream()
                    .filter(rec -> rec.getDiagnosis().contains(diagnosis))
                    .map(rec -> new RecordListResponseDto(
                            rec.getId(), rec.getPatientId(), rec.getDateOfVisit()
                            ,rec.getDiagnosis(), rec.getTreatment(), new Date()
                    )).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dtos;
    }


    @Override
    public void deleteRecord(Long id) {
        try {
            HealthRecord record = recordRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID의 건강기록이 존재하지 않습니다."));
            recordRepository.delete(record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 진단별 카운팅
    @Override
    public Map<String, Long> getCountGroupingByDiagnosis() {
        return recordRepository.findAll().stream()
                .collect(Collectors.groupingBy(rec -> rec.getDiagnosis(), Collectors.counting()));
    }

    // 특정 연령대의 환자 건강기록 목록
    @Override
    public List<RecordListResponseDto> filterRecordsByAge(int minAge) {

        return recordRepository.findAll().stream()
                .filter(rec -> {
                    Optional<Patient> pt = patientRepository.findById(rec.getPatientId());
                    return pt.isPresent() && pt.get().getAge() >= minAge;
                }).map(rec -> new RecordListResponseDto(
                        rec.getId(), rec.getPatientId(), rec.getDateOfVisit(),
                        rec.getDiagnosis(), rec.getTreatment(), new Date()
                )).toList();
    }

    // 특정 기간 내 환자 조회
    @Override
    public List<RecordListResponseDto> filterRecordsByDateRange(String from, String end) {
        DateValidator.validateOrThrow(from);
        DateValidator.validateOrThrow(end);

        LocalDate fromDate = LocalDate.parse(from, DateValidator.FORMATTER);
        LocalDate endDate = LocalDate.parse(end, DateValidator.FORMATTER);

        return recordRepository.findAll().stream()
                .filter(rec -> {
                    LocalDate visitDate = LocalDate.parse(rec.getDateOfVisit(), DateValidator.FORMATTER);
                    return !visitDate.isBefore(fromDate) && !visitDate.isAfter(endDate);
                }).map(rec -> new RecordListResponseDto(
                        rec.getId(), rec.getPatientId(), rec.getDateOfVisit(), rec.getDiagnosis()
                        ,rec.getTreatment(), new Date()
                )).collect(Collectors.toList());
    }
}
