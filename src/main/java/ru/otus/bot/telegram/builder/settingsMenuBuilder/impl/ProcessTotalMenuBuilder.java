package ru.otus.bot.telegram.builder.settingsMenuBuilder.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.settingsMenuBuilder.SettingMenuBuilder;
import ru.otus.bot.telegram.data.CarMaintenance;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MaintenanceType;
import ru.otus.bot.telegram.integration.http.CarMaintenanceRequestService;
import ru.otus.bot.telegram.service.BotStateStorageService;


@Component
@RequiredArgsConstructor
public class ProcessTotalMenuBuilder implements SettingMenuBuilder {
    private final CarMaintenanceRequestService requestService;
    private final BotStateStorageService botStateStorageService;

    @Override
    public void processUserAnswer(long userId, String userAnswer) {
        botStateStorageService.setCurrentBotState(userId, BotState.MEINTENANCE);
        requestService.sendCarMaintenance(new CarMaintenance().setUserId(String.valueOf(userId))
                                                              .setValue(Integer.parseInt(userAnswer))
                                                              .setMaintenanceType(MaintenanceType.TOTAL));
    }

    @Override
    public BotState getBotState() {
        return BotState.PROCESS_TOTAL;
    }
}
