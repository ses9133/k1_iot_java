package org.example.user_reservation.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor    // final 또는 @NonNull 인 필드만 생성자 매개변수로 받음
@Getter
public class Reservation {
    private final Long reservationId;
    private final String userId;
    private final Date reservationTime;

    // 활성화 유무를 저장
    // : 해당 예약의 활성화 상태를 저장
    // - true: 예약 완료(예약 중)
    // - false: 예약 취소
    private boolean isActive = true;

    // 예약 취소 메서드
    public void cancel() {
        this.isActive = false;
    }

//    @Override
//    public String toString() {
//        String isActiveMessage = isActive ? "예약중" : "예약취소";
//        return "[예약 ID: " + reservationId + ", 예약자 ID: " + userId + ", 예약 일자: " + reservationTime
//                + ", 예약 상태: " + isActiveMessage + "]";
//    }
}
