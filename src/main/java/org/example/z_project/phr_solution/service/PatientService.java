package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;

import java.util.List;

public interface PatientService {
    // C R(전체, 단건) U D
    void registerPatient(PatientCreateRequestDto dto);  // 환자 생성 요청 dto
    List<PatientListResponseDto> listAllPatients();
    PatientDetailResponseDto getPatientById(Long id);
    void updatePatient(Long id, PatientUpdateRequestDto dto);   // 환자 수정 요청 dto
    void deletePatient(Long id);
}

