package ru.otus.bot.telegram.handler.userAnswerHandleImpl.statisticMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.utils.BotApiFactory;


@Component
@RequiredArgsConstructor
public class StatisticHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final BotApiFactory botApiFactory;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        return messageBuilder.createMessageWithKeyboard(Long.parseLong(chatId), messageBuilder.getTranslatedMessage("statistics.data"),
                botApiFactory.getBotApi(BotApiNames.STATISTICS).getApi());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.MY_STATISTICS;
    }
}
