package ru.otus.bot.telegram.builder.costsMenuBuilder;

import ru.otus.bot.telegram.data.enums.MetricType;

public interface CostsMenuStateBuilder {
    void processUserAnswer(long userId, String usersAnswer);
    MetricType getMetricName();
}
