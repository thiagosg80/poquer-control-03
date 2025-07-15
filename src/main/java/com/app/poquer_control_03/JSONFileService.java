package com.app.poquer_control_03;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class JSONFileService {
    public JsonNode getContent(final String fullFilename) throws IOException {
        final Path path = FullPathService.get(fullFilename);
        final byte[] bytes = Files.readAllBytes(path);
        final String content = new String(bytes);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(content);
    }
}
