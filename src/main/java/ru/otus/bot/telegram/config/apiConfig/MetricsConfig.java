package ru.otus.bot.telegram.config.apiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MetricsConfig {
    @Value("${bot.api.subPath.metrics}")
    private String metricSubPath;

    @Value("${bot.api.baseurlForMetricService}")
    private String baseurlForMetricService;
}
