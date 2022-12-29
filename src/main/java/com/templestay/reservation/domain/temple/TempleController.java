package com.templestay.reservation.domain.temple;

import org.springframework.stereotype.Controller;

@Controller
public class TempleController {

    private final TempleService templeService;

    public TempleController(TempleService templeService) {
        this.templeService = templeService;
    }

    public void templeListInit() {
        templeService.saveAllTempleList();
    }
}
