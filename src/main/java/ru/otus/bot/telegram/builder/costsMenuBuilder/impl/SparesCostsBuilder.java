package ru.otus.bot.telegram.builder.costsMenuBuilder.impl;

import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.costsMenuBuilder.CostsMenuStateBuilder;
import ru.otus.bot.telegram.data.Metrics;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MetricType;
import ru.otus.bot.telegram.integration.http.MetricsRequestService;
import ru.otus.bot.telegram.integration.kafka.publisher.MetricsProducerService;
import ru.otus.bot.telegram.service.BotStateStorageService;


@Component
@RequiredArgsConstructor
public class SparesCostsBuilder implements CostsMenuStateBuilder {
    private final BotStateStorageService botStateStorageService;
    private final MetricsProducerService metricsProducerService;

    @Override
    public void processUserAnswer(long userId, String usersAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.MY_COSTS);
        metricsProducerService.sendMetric(new Metrics().setUserId(String.valueOf(userId))
                                                                   .setMetricType(MetricType.SPARES)
                                                                   .setValue(usersAnswer)
                                                                    .setId(UUID.randomUUID().toString())
                                                                   .setDate(LocalDate.now()));
    }

    @Override
    public MetricType getMetricName() {
        return MetricType.SPARES;
    }
}
