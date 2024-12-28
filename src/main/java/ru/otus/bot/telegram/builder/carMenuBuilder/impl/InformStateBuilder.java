package ru.otus.bot.telegram.builder.carMenuBuilder.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.carMenuBuilder.CarMenuStateBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.integration.publisher.CarHandlerRequestService;
import ru.otus.bot.telegram.service.BotStateStorageService;
import ru.otus.bot.telegram.storage.CarCacheService;


@Component
@RequiredArgsConstructor
public class InformStateBuilder implements CarMenuStateBuilder {
    private final BotStateStorageService botStateStorageService;
    private final CarCacheService carCacheService;
    private final CarHandlerRequestService carHandlerRequestService;

    @Override
    public void processUserAnswer(long userId, String usersAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.INFORM);
        carCacheService.setCarYear(userId, usersAnswer);
        carHandlerRequestService.sendCarToCarHandler(carCacheService.getCarByUserId(userId));
    }

    @Override
    public BotState getBotStateName() {
        return BotState.INFORM;
    }
}
