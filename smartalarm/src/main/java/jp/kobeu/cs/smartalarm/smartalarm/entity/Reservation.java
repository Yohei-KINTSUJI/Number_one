package jp.kobeu.cs.smartalarm.smartalarm.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rid;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String title;
    String location;
}
