package ru.otus.bot.telegram.handler.userAnswerHandleImpl.settingsMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.utils.SettingMenuFactory;

@Component
@RequiredArgsConstructor
public class ScheduleHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final SettingMenuFactory settingMenuFactory;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        settingMenuFactory.getSettingMenuByState(BotState.SCHEDULE).processUserAnswer(userId,usersAnswer);
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("maintenance.data"))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SCHEDULE;
    }
}
