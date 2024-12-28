package ru.otus.bot.telegram.builder.statisticMenuBuilder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.service.BotStateStorageService;

@Component
@RequiredArgsConstructor
public class StatisticsMenuBuilder {
    private final BotStateStorageService botStateStorageService;

    public void setBotState(long userId){
        botStateStorageService.setCurrentBotState(userId, BotState.MY_STATISTICS);
    }
}
