package com.app.poquer_control_03.fight;

import com.app.poquer_control_03.JSONFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.io.IOException;

@Service
public class FightService {

    private final JSONFileService jsonFileService;

    @Value("${basedados-path}")
    String databasePath;

    @Value("${players-filename}")
    String playersFilename;

    public FightService(JSONFileService jsonFileService) {
        this.jsonFileService = jsonFileService;
    }

    public Fight getFight() throws IOException {
        final JsonNode jsonNode = jsonFileService.getContent(databasePath.concat(playersFilename));

        return new Fight(jsonNode.size(), getPlayingQuantity(jsonNode));
    }

    private Integer getPlayingQuantity(JsonNode jsonNode) {
        return jsonNode.valueStream()
                .filter(i -> !i.get("isEliminado").asBoolean())
                .toList()
                .size();
    }
}
