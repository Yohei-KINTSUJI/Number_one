package jp.kobeu.cs.smartalarm.smartalarm.controller;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReservationForm {
    LocalDateTime startTime;
    LocalDateTime endTime;
    String title;
    String location;
}