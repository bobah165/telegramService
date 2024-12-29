package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

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
public class CarProfileHandler implements UserAnswerHandler {
    private final BotApiFactory botApiFactory;
    private final MessageBuilder messageBuilder;

    @Override
    public BotState getHandlerName() {
        return BotState.MY_CAR;
    }

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        return messageBuilder.createMessageWithKeyboard(Long.parseLong(chatId), messageBuilder.getTranslatedMessage("car.api"),
                botApiFactory.getBotApi(BotApiNames.MY_CAR_API).getApi());
    }
}
