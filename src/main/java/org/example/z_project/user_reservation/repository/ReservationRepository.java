package org.example.z_project.user_reservation.repository;

import org.example.z_project.user_reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    // 예약 등록(C),
    //  : DB 에 새로운 예약을 저장
    // +) 요청값(예약 정보), 응답 X
    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    // 조회(R)
    // : 단건 예약에 대한 조회 (reservationId 를 사용)
    // +) 요청값(reservationId), 응답(예약 정보)
    public Optional<Reservation> findById(Long reservationId) {
        return reservations.stream()
                .filter(res -> res.getReservationId().equals(reservationId))
                .findFirst();   // 검색된 조건에 일치하는 요소 중에 제일 첫번째 요소를 OPtional 로 반환
    }
    // : 예약자 정보와 일치하는 예약을 조회 (userId 를 사용)
    // +) 요청(userId), 응답(예약 정보 리스트 반환)
    public List<Reservation> findByUserId(String userId) {
        return reservations.stream()
                                                                    // 예약이 유효한 목록만 확인
                .filter(res -> res.getUserId().equals(userId) && res.isActive())
                .toList();
    }

    // 취소(Update!!)
    // : (현재 프로젝트에서는 DB 없이 객체 내부의 상태만 변경할 것임 - 취소 자체의 로직 X)


}
