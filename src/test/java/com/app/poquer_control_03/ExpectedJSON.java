package com.app.poquer_control_03;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ExpectedJSON {
    public static String get(String fileName) throws IOException, JSONException {
        final String fullName = "/expected/".concat(fileName).concat(".json");
        final File file = new ClassPathResource(fullName).getFile();
        final String content = new String(Files.readAllBytes(file.toPath()));
        final JSONObject jsonObject = new JSONObject(content);

        return jsonObject.toString();
    }
}
