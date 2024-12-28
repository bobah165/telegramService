package ru.otus.bot.telegram.handler.userAnswerHandleImpl.costsMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.MetricType;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.utils.CostsMenuFactory;
import ru.otus.bot.telegram.utils.UserAnswerValidatorFactory;


@Component
@RequiredArgsConstructor
public class MileageCostsHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final CostsMenuFactory costsMenuFactory;
    private final UserAnswerValidatorFactory answerValidator;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        answerValidator.getUserAnswerValidator(BotState.METRICS).validateUserAnswer(usersAnswer, chatId);
        costsMenuFactory.getCostsMenuByState(MetricType.MILEAGE).processUserAnswer(userId,usersAnswer);
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("costs.choose.menu"))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.COSTS_MILEAGE;
    }

}
