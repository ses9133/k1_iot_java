package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;

import java.util.List;
import java.util.Map;

public interface HealthRecordService {
    void createdRecord(RecordCreateRequestDto dto);
    List<RecordListResponseDto> getAllRecords();
    List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis);
    void deleteRecord(Long id);
    Map<String, Long> getCountGroupingByDiagnosis();
    List<RecordListResponseDto> filterRecordsByAge(int minAge);
    List<RecordListResponseDto> filterRecordsByDateRange(String from, String end);
}
