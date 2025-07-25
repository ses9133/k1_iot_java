package org.example.z_project.phr_solution;

/*
    PHR (개인 건강 기록, Personal Health Record) 솔루션

    1. 프로젝트 개요
    - 개인 건강 기록(PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
    - 환자의 기본 정보를 관리, 환자의 건강 기록 등록, 수정, 조회 가능
    - 특정 조건에 맞는 건강 기록을 필터링하고 집계 기능

    2. 주요 기능 & 비즈니스 로직
    - 환자 정보 관리(Patient) : CR(단건, 전체)UD
    - 건강 기록 관리(HealthRecord) : CRUD + 필터링(조회)

    3. 비즈니스 로직 구조
    - controller: 사용자 입력 처리 + 알맞은 서비스 메서드 호출
    - service: 핵심 비즈니스 로직 수행
    - repository : 데이터 저장소 (DB)와의 상호작용 담당
    - dto : 계층 간 데이터 전송을 위한 객체
    - entity: 데이터 저장소(DB) 의 테이블과 매핑되는 도메인 객체

    4. 실행 및 관리
    - App.java : 프로그램 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
            >> App.java 가 사용자 입력 처리, 메뉴 출력, 흐름 제어 모두 담당 -> SRP 위반
            >> 따라서 handler + App.java 로 구분
 */

import org.example.z_project.phr_solution.controller.HealthRecordController;
import org.example.z_project.phr_solution.controller.PatientController;
import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.handler.InputHandler;
import org.example.z_project.phr_solution.handler.MenuPrinter;

import java.util.List;

public class App {
    private static final PatientController patientController = new PatientController();
    private static final HealthRecordController healthRecordController = new HealthRecordController();

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1: {
                PatientCreateRequestDto requestDto = InputHandler.createPatientRequest();
                if(requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }
                patientController.registerPatient(requestDto);
                break;
            }
            case 2: {
                List<PatientListResponseDto> patients = patientController.getAllPatients();
                if(patients.isEmpty()) {
                    System.out.println("환자 정보가 없습니다.");
                } else {
                    patients.forEach(System.out::println);
                }
                break;
            }
            case 3: {
                Long id = InputHandler.getIdInput();
                PatientDetailResponseDto patient = patientController.getPatientById(id);
                if(patient == null) {   // PtService 확인(-)
                    System.out.println("해당하는 ID 의 환자가 없습니다.");
                } else {
                    System.out.println(patient);
                }
                break;
            }
            case 4: {
                Long id = InputHandler.getIdInput();
                PatientUpdateRequestDto requestDto = InputHandler.updatePatientRequest();
                if(requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }
                patientController.updatePatient(id, requestDto);
                break;
            }
            case 5: {
                Long id = InputHandler.getIdInput();
                patientController.deletePatient(id);
                break;
            }
            // 건강 관련 기능
            case 6: {
                RecordCreateRequestDto dto = InputHandler.createRequestDto();

               if(dto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }

                healthRecordController.createRecord(dto);

                break;
            }
            case 7: {
                List<RecordListResponseDto> records = healthRecordController.getAllRecords();

                if(records.isEmpty()) {
                    System.out.println("건강 기록이 없습니다.");
                } else {
                    records.forEach(System.out::println);
                }
                break;
            }
            case 8: {
                System.out.println("필터링할 조건을 입력하세요. 1. 진단명, 2. 특정 나이 기준 이상의 기록");
                int menu = InputHandler.getChoice();

                if(menu == 1) {
                    String diagnosisFilter = InputHandler.getInput("필터 조건 (진단명)");
                    List<RecordListResponseDto> filteredRecords
                            = healthRecordController.filterRecordsByDiagnosis(diagnosisFilter);
                    if(filteredRecords.isEmpty()) {
                        System.out.println("검색 결과를 찾을 수 없습니다.");

                    } else {
                        filteredRecords.forEach(System.out::println);
                    }

                } else if (menu == 2) {

                    try {
                        System.out.println("조회를 원하는 나이를 입력해주세요: ");
                        int age =InputHandler.getInputNum();
                        List<RecordListResponseDto> filteredByAgeRecords
                                = healthRecordController.filterRecordsByAge(age);

                        if(filteredByAgeRecords.isEmpty()) {
                            System.out.println("검색 결과를 찾을 수 없습니다.");
                        } else {
                            filteredByAgeRecords.forEach(System.out::println);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    System.out.println("유효한 숫자 값을 입력하세요");
                }
                break;
            }
            case 9: {
                Long id = InputHandler.getIdInput();
                healthRecordController.deleteRecord(id);
                break;
            }

            case 10: {
                System.out.println("프로그램을 종료합니다.");
                return false;
            }
            default:
                System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요");
                break;

        }
        return true;
    }

    public static void main(String[] args) {

        try {
           while(true) {
               MenuPrinter.displayMenu();
               int choice = InputHandler.getChoice();
               if(!processChoice(choice)) break;
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            InputHandler.closeScanner();
        }
    }
}
