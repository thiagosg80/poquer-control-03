package com.app.poquer_control_03.monetary;

import com.app.poquer_control_03.JSONFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;

@Service
public class MonetaryService {

    private final JSONFileService jsonFileService;

    @Value("${basedados-path}")
    String databasePath;

    @Value("${players-filename}")
    String playersFilename;

    @Value("${percents-filename}")
    String percentsFilename;

    public MonetaryService(JSONFileService jsonFileService) {
        this.jsonFileService = jsonFileService;
    }

    public Monetary getMonetary() throws IOException {
        return new Monetary(getTotal(), getAwards());
    }

    private List<Award> getAwards() throws IOException {
        final JsonNode jsonNode = jsonFileService.getContent(databasePath.concat(percentsFilename));
        final Double total = getTotal();

        return jsonNode.valueStream()
                .map(i -> getAward(i, total))
                .toList();
    }

    private Award getAward(final JsonNode jsonNode, final Double total) {
        final double percentage = jsonNode.get("percentage").asDouble();

        return new Award(jsonNode.get("position").asInt(), total * (percentage / 100), percentage);
    }

    private Double getTotal() throws IOException {
        final JsonNode jsonNode = jsonFileService.getContent(databasePath.concat(playersFilename));

        return jsonNode.valueStream()
                .map(i -> i.get("compra").asDouble() + i.get("recompra").asDouble())
                .reduce((double) 0, Double::sum);
    }
}
