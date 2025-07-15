package com.app.poquer_control_03.fight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/fights")
public class FightController {

    private final FightService service;

    public FightController(FightService service) {
        this.service = service;
    }

    @GetMapping
    Fight getFight() throws IOException {
        return service.getFight();
    }
}
