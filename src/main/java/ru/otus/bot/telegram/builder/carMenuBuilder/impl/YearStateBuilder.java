package ru.otus.bot.telegram.builder.carMenuBuilder.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.carMenuBuilder.CarMenuStateBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.service.BotStateStorageService;
import ru.otus.bot.telegram.storage.CarCacheService;


@Component
@RequiredArgsConstructor
public class YearStateBuilder implements CarMenuStateBuilder {
    private final BotStateStorageService botStateStorageService;
    private final CarCacheService carCacheService;

    @Override
    public void processUserAnswer(long userId, String usersAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.YEAR);
        carCacheService.setCarTransmission(userId, usersAnswer);
    }

    @Override
    public BotState getBotStateName() {
        return BotState.YEAR;
    }
}
