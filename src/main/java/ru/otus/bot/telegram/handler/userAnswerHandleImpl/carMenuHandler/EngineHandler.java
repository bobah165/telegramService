package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.utils.BotApiFactory;
import ru.otus.bot.telegram.utils.CarMenuStateFactory;
import ru.otus.bot.telegram.utils.UserAnswerValidatorFactory;


@Component
@RequiredArgsConstructor
public class EngineHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final BotApiFactory botApiFactory;
    private final CarMenuStateFactory carMenuStateFactory;
    private final UserAnswerValidatorFactory answerValidator;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        answerValidator.getUserAnswerValidator(BotState.ENGINE).validateUserAnswer(usersAnswer, chatId);
        carMenuStateFactory.getCarMenuByState(BotState.TRANSMISSION)
                           .processUserAnswer(userId, usersAnswer);

        return messageBuilder.createMessageWithKeyboard(Long.parseLong(chatId), messageBuilder.getTranslatedMessage("car.transmission"),
                botApiFactory.getBotApi(BotApiNames.TRANSMISSION_API).getApi());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ENGINE;
    }
}
