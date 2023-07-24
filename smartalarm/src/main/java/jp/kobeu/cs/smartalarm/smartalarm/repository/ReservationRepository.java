package jp.kobeu.cs.smartalarm.smartalarm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobeu.cs.smartalarm.smartalarm.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    
}
