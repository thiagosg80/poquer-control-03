package com.app.poquer_control_03.monetary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/monetaries")
public class MonetaryController {

    private final MonetaryService service;

    public MonetaryController(MonetaryService service) {
        this.service = service;
    }

    @GetMapping
    Monetary getMonetary() throws IOException {
        return service.getMonetary();
    }
}
