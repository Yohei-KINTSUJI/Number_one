package jp.kobeu.cs.smartalarm.smartalarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobeu.cs.smartalarm.smartalarm.entity.Reservation;
import jp.kobeu.cs.smartalarm.smartalarm.repository.ReservationRepository;


@Service

public class ReservationService {
    @Autowired
    ReservationRepository rRepo; // レポジトリ
    public Reservation addReservation(Reservation res) {
        
    }
}