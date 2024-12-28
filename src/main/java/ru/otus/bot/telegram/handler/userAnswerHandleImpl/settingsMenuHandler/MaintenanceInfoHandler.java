package ru.otus.bot.telegram.handler.userAnswerHandleImpl.settingsMenuHandler;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.CarMaintenance;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MaintenanceType;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.integration.publisher.CarMaintenanceRequestService;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.utils.SettingMenuFactory;


@Component
@RequiredArgsConstructor
public class MaintenanceInfoHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final SettingMenuFactory settingMenuFactory;
    private final CarMaintenanceRequestService carMaintenanceRequestService;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        settingMenuFactory.getSettingMenuByState(BotState.MAINTENANCE_INFO).processUserAnswer(userId, usersAnswer);
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(getMessage(userId))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.MAINTENANCE_INFO;
    }

    private String getMessage(Long userId) {
        List<CarMaintenance> carMaintenanceList = carMaintenanceRequestService.getCarMaintenance(String.valueOf(userId));
        return messageBuilder.getTranslatedMessage("total.message.output") + ": " + getCarMaintenanceByType(carMaintenanceList, MaintenanceType.TOTAL) + "\n" +
                messageBuilder.getTranslatedMessage("reminder.message.output") + ": " + getCarMaintenanceByType(carMaintenanceList, MaintenanceType.REMIND) + "\n" +
                messageBuilder.getTranslatedMessage("schedule.message.output") + ": " + getCarMaintenanceByType(carMaintenanceList, MaintenanceType.SCHEDULE);
    }

    private int getCarMaintenanceByType(List<CarMaintenance> carMaintenanceList, MaintenanceType type) {
        return carMaintenanceList.stream()
                                 .filter(carMaintenance -> carMaintenance.getMaintenanceType() == type)
                                 .map(CarMaintenance::getValue)
                                 .findFirst()
                                 .orElse(0);
    }
}
