package org.example.z_project.phr_solution.dto.health_record.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class RecordListResponseDto {

    private Long id;
    private Long patientId;
    private String dateOfVisit;
    private String diagnosis;
    private String treatment;

    // 응답은 DB에 없는 내용도 전달할 수있음
    private Date inquiryTime; // 건강 기록 조회 시간
}
