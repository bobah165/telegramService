package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.costsMenuBuilder.CostsMenuStateBuilder;
import ru.otus.bot.telegram.data.enums.MetricType;

@Component
@RequiredArgsConstructor
public class CostsMenuFactory {
    private final List<CostsMenuStateBuilder> costsMenuStateBuilders;

    public CostsMenuStateBuilder getCostsMenuByState(MetricType metricType) {
        return costsMenuStateBuilders.stream()
                                     .collect(Collectors.toMap(CostsMenuStateBuilder::getMetricName, Function.identity()))
                                     .get(metricType);
    }
}
