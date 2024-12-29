package ru.otus.bot.telegram.builder.costsMenuBuilder.impl;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.costsMenuBuilder.CostsMenuStateBuilder;
import ru.otus.bot.telegram.data.Metrics;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MetricType;
import ru.otus.bot.telegram.integration.http.MetricsRequestService;
import ru.otus.bot.telegram.service.BotStateStorageService;


@Component
@RequiredArgsConstructor
public class GasCostsBuilder implements CostsMenuStateBuilder {
    private final BotStateStorageService botStateStorageService;
    private final MetricsRequestService metricsRequestService;

    @Override
    public void processUserAnswer(long userId, String usersAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.MY_COSTS);
        metricsRequestService.sendMetricsToCarHandler(new Metrics().setUserId(String.valueOf(userId))
                                                                   .setMetricType(MetricType.GAS)
                                                                   .setValue(usersAnswer)
                                                                   .setDate(LocalDate.now()));
    }

    @Override
    public MetricType getMetricName() {
        return MetricType.GAS;
    }
}
