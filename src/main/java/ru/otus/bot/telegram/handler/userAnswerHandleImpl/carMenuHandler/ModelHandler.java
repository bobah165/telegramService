package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.utils.CarMenuStateFactory;
import ru.otus.bot.telegram.utils.UserAnswerValidatorFactory;


@Component
@RequiredArgsConstructor
public class ModelHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final CarMenuStateFactory carMenuStateFactory;
    private final UserAnswerValidatorFactory answerValidator;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        answerValidator.getUserAnswerValidator(BotState.MODEL).validateUserAnswer(usersAnswer, chatId);
        carMenuStateFactory.getCarMenuByState(BotState.MILEAGE)
                           .processUserAnswer(userId, usersAnswer);

        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("car.mileage"))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.MODEL;
    }
}
