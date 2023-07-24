package jp.kobeu.cs.smartalarm.smartalarm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobeu.cs.smartalarm.smartalarm.entity.Reservation;
import jp.kobeu.cs.smartalarm.smartalarm.repository.ReservationRepository;

@Service

public class ReservationService {
    @Autowired
    ReservationRepository rRepo; // レポジトリ

    public Reservation addReservation(Reservation res) {
        String title = res.getTitle();
        String location = res.getLocation();
        LocalDateTime startTime = res.getStartTime();
        LocalDateTime endTime = res.getEndTime();

        if (title == null || title.length() == 0) {
            res.setTitle("Empty title");
        }
        if (location == null || location.length() == 0) {
            res.setLocation("Empty location");
        }
        if (startTime == null) {
            res.setEndTime(LocalDateTime.now().minusHours(1));
        }
        if (endTime == null) {
            res.setEndTime(LocalDateTime.now().plusHours(1));
        }

        return rRepo.save(res);
    }

    public List<Reservation> getAllResevations() {
        Iterable<Reservation> found = rRepo.findAll();
        ArrayList<Reservation> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    public boolean deleteReservationById(Long reservationId) {
        // Check if the reservation with the given ID exists in the database
        if (rRepo.existsById(reservationId)) {
            // If the reservation exists, delete it
            rRepo.deleteById(reservationId);
            System.out.println("Reservation with ID " + reservationId + " has been deleted.");
            return true;
        } else {
            System.out.println("Reservation with ID " + reservationId + " not found. Deletion failed.");
        }
        return false;
    }

}