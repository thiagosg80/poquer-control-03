package com.app.poquer_control_03.fight;

import com.app.poquer_control_03.JSONFileService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

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
        final Fight fight = new Fight();
        fight.setTotal(jsonNode.size());
        fight.setPlaying(getPlayingQuantity(jsonNode));

        return fight;
    }

    private Integer getPlayingQuantity(JsonNode jsonNode) {
        return jsonNode.valueStream()
                .filter(i -> i.get("isEliminado").asBoolean())
                .toList()
                .size();
    }
}
