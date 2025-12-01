package com.app.poquer_control_03.fight;

import com.app.poquer_control_03.ExpectedJSON;
import com.app.poquer_control_03.MockGet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveObterAQuantidadeTotalDeJogadoresEAQuantidadeAtualDeJogadores() throws Exception {
        final String actual = MockGet.perform("/api/fights", mockMvc);
        final String expected = ExpectedJSON.get("expected-fight");

        assertThat(actual, is(expected));
    }
}
