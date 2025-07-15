package com.app.poquer_control_03;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ExpectedJSON {
    public static String get(String fileName) throws IOException {
        final String fullName = "/expected/".concat(fileName).concat(".json");
        final File file = new ClassPathResource(fullName).getFile();
        final String content = new String(Files.readAllBytes(file.toPath()));
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(content).toString();
    }
}
