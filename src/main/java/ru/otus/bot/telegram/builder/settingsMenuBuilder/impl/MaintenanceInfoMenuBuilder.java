package ru.otus.bot.telegram.builder.settingsMenuBuilder.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.settingsMenuBuilder.SettingMenuBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.service.BotStateStorageService;

@Component
@RequiredArgsConstructor
public class MaintenanceInfoMenuBuilder implements SettingMenuBuilder {
    private final BotStateStorageService botStateStorageService;

    @Override
    public void processUserAnswer(long userId, String userAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.MEINTENANCE);
    }

    @Override
    public BotState getBotState() {
        return BotState.MAINTENANCE_INFO;
    }
}
