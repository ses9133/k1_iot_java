package org.example.z_project.phr_solution.controller;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.service.HealthRecordService;
import org.example.z_project.phr_solution.service.implement.HealthRecordServiceImpl;

import java.util.List;
import java.util.Map;

public class HealthRecordController {
    private final HealthRecordService healthRecordService;

    public HealthRecordController() {
        this.healthRecordService = new HealthRecordServiceImpl();
    }

    public void createRecord(RecordCreateRequestDto dto) {
        healthRecordService.createdRecord(dto);
    }

    public List<RecordListResponseDto> getAllRecords() {
        return healthRecordService.getAllRecords();
    }

    // 필터링(검색 기능)
    public List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis) {
        return healthRecordService.filterRecordsByDiagnosis(diagnosis);
    }

    // 진단별 카운팅
    public Map<String, Long> getCountGroupingByDiagnosis() {
        return healthRecordService.getCountGroupingByDiagnosis();
    }

    // 특정 연령이상의 기록 조회
    public List<RecordListResponseDto> filterRecordsByAge(int minAge) {
        return healthRecordService.filterRecordsByAge(minAge);
    }

    public void deleteRecord(Long id) {
        healthRecordService.deleteRecord(id);
    }
}
