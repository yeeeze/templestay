package com.templestay.reservation.domain.temple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TempleController {

    private final TempleService templeService;

    public TempleController(TempleService templeService) {
        this.templeService = templeService;
    }

    public void templeListInit() {
        templeService.saveAllTempleList();
    }

    /**
     * 오픈 알림 신청 페이지
     */
    @GetMapping("/view/index")
    public String applyOpenAlarm(Model model) {
        List<Temple> templeList = templeService.getAllTemple();
        model.addAttribute("temples", templeList);
        return "index";
    }
}
