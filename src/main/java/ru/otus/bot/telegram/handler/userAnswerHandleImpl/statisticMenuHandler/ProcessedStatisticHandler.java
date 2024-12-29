package ru.otus.bot.telegram.handler.userAnswerHandleImpl.statisticMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.builder.statisticMenuBuilder.StatisticsMenuBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MetricType;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.integration.http.MetricsRequestService;
import ru.otus.bot.telegram.service.LanguageTranslatorService;


@Component
@RequiredArgsConstructor
public class ProcessedStatisticHandler implements UserAnswerHandler {
    private final StatisticsMenuBuilder statisticsMenuBuilder;
    private final LanguageTranslatorService translatorService;
    private final MetricsRequestService metricsRequestService;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        String data = getDataByMetrics(userId, usersAnswer);
        statisticsMenuBuilder.setBotState(userId);

        return SendMessage.builder()
                          .chatId(chatId)
                          .text(data)
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.PROCESSED_STATISTICS;
    }

    private String getDataByMetrics(long userId, String usersAnswer) {
        switch (usersAnswer) {
            case "mileage":
                return translatorService.translateMessage("message.stat.mileage") + " " + getValue(userId, MetricType.MILEAGE) + " " + translatorService.translateMessage("measure.const.km");
            case "gas":
                return translatorService.translateMessage("message.stat.gas") + " " + getValue(userId, MetricType.GAS) + " " + translatorService.translateMessage("measure.const.money");
            case "spares":
                return translatorService.translateMessage("message.stat.spares") + " " + getValue(userId, MetricType.SPARES) + " " + translatorService.translateMessage("measure.const.money");
            default:
                return "";
        }
    }

    private String getValue(long userId, MetricType metricType) {
        return metricsRequestService.getMetricsFromCarHandler(String.valueOf(userId), metricType).getValue();
    }
}
