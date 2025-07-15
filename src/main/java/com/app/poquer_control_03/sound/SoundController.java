package com.app.poquer_control_03.sound;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

@RestController
@RequestMapping("api/sounds")
public class SoundController {

    private final SoundService service;

    public SoundController(SoundService service) {
        this.service = service;
    }

    @PostMapping("play")
    void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        service.play();
    }
}
