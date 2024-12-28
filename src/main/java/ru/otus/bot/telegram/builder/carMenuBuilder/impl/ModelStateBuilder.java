package ru.otus.bot.telegram.builder.carMenuBuilder.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.carMenuBuilder.CarMenuStateBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.service.BotStateStorageService;

@Component
@RequiredArgsConstructor
public class ModelStateBuilder implements CarMenuStateBuilder {
    private final BotStateStorageService botStateStorageService;

    @Override
    public void processUserAnswer(long userId, String usersAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.MODEL);
    }

    @Override
    public BotState getBotStateName(){
        return BotState.MODEL;
    }
}
