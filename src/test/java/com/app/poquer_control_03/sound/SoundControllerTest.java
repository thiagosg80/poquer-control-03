package com.app.poquer_control_03.sound;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SoundControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveTocarOAvisoSonoro() throws Exception {
        mockMvc.perform(post("/api/sounds/play"))
                .andExpect(status().is2xxSuccessful());
    }
}
