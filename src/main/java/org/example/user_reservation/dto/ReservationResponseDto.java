package org.example.user_reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@ToString
public class ReservationResponseDto {
    private Long reservationId;
    private String userId;
    private Date reservationTime;
    private String activeMessage;

    //    @Override
//    public String toString() {
//        String isActiveMessage = isActive ? "예약중" : "예약취소";
//        return "[예약 ID: " + reservationId + ", 예약자 ID: " + userId + ", 예약 일자: " + reservationTime
//                + ", 예약 상태: " + isActiveMessage + "]";
//    }
}
