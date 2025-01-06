package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.config.apiConfig.MetricsConfig;
import ru.otus.bot.telegram.data.Metrics;
import ru.otus.bot.telegram.data.enums.MetricType;
import ru.otus.bot.telegram.service.RequestService;

@Component
@RequiredArgsConstructor
public class MetricsRequestService {

    private final RequestService requestService;
    private final MetricsConfig metricsConfig;


    public Metrics getMetricsFromCarHandler(String userId, MetricType metricType) {
        ParameterizedTypeReference<Metrics> typeReference = new ParameterizedTypeReference<>() {};
        String uri = metricsConfig.getBaseurlForMetricService() + metricsConfig.getMetricSubPath() + "/" + userId + "/" + metricType;
        return requestService.get(uri, typeReference);
    }
}
