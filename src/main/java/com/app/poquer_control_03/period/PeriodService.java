package com.app.poquer_control_03.period;

import com.app.poquer_control_03.JSONFileService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PeriodService {

    private final JSONFileService jsonFileService;

    @Value("${basedados-path}")
    String databasePath;

    @Value("${periods-filename}")
    String periodsFilename;

    public PeriodService(JSONFileService jsonFileService) {
        this.jsonFileService = jsonFileService;
    }

    public List<Period> getPeriods() throws IOException {
        final JsonNode jsonNode = jsonFileService.getContent(databasePath.concat(periodsFilename));
        final AtomicInteger index = new AtomicInteger(1);

        return jsonNode.valueStream()
                .map(i -> getPeriod(i, index.getAndIncrement()))
                .toList();
    }

    private Period getPeriod(JsonNode jsonNode, final Integer index) {
        final Duration duration = new Duration(jsonNode.get("seconds").asInt(), jsonNode.get("minutes").asInt());

        final Bet bet = new Bet(jsonNode.get("smallBlind").asDouble(), jsonNode.get("bigBlind").asDouble(),
                jsonNode.get("ante").asDouble());

        return new Period(index, false, duration, bet);
    }
}
