package ru.otus.bot.telegram.handler.userAnswerHandleImpl.costsMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.BotStateStorageService;
import ru.otus.bot.telegram.service.MessageBuilder;

@Component
@RequiredArgsConstructor
public class AskAboutSparesHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final BotStateStorageService botStateStorageService;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        botStateStorageService.setCurrentBotState(userId, BotState.COSTS_SPARES);
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("costs.spares"))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ASK_ABOUT_SPARES_COSTS;
    }
}
