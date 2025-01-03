package ru.otus.bot.telegram.handler.userAnswerHandleImpl.costsMenuHandler;

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
public class CostsHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final BotApiFactory botApiFactory;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        return messageBuilder.createMessageWithKeyboard(Long.parseLong(chatId), messageBuilder.getTranslatedMessage("costs.choose.menu"),
                botApiFactory.getBotApi(BotApiNames.MY_COSTS_API).getApi());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.MY_COSTS;
    }
}
