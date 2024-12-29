package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.config.apiConfig.MetricsConfig;
import ru.otus.bot.telegram.data.Metrics;
import ru.otus.bot.telegram.data.enums.MetricType;

@Component
@RequiredArgsConstructor
public class MetricsRequestService {

    private final MetricsConfig metricsConfig;


    public void sendMetricsToCarHandler(Metrics metrics) {
    }


    public Metrics getMetricsFromCarHandler(String userId, MetricType metricType) {
        return new Metrics();
    }
}
