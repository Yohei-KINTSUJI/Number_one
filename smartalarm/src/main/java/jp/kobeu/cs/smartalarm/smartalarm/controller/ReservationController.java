package jp.kobeu.cs.smartalarm.smartalarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobeu.cs.smartalarm.smartalarm.entity.Reservation;
import jp.kobeu.cs.smartalarm.smartalarm.service.ReservationService;

@Controller
public class ReservationController {

    @Autowired
    ReservationService rs;

    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    @GetMapping("/calendar")
    String showReservationList(Model model) {
        List<Reservation> list = rs.getAllResevations(); // 全つぶやきを取得
        model.addAttribute("reservationList", list); // モデル属性にリストをセット
        model.addAttribute("reservationForm", new ReservationForm()); // 空フォームをセット
        return "reservation";
    }

    @PostMapping("/reservation")
    String addReservation(@ModelAttribute("reservationForm") ReservationForm form, Model model) {
        Reservation res = new Reservation();
        res.setTitle(form.getTitle());
        res.setLocation(form.getLocation());
        res.setStartTime(form.getStartTime());
        res.setEndTime(form.getEndTime());

        rs.addReservation(res);
        return "redirect:/calendar";
    }

}
