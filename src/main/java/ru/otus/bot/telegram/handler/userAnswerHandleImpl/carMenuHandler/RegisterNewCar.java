package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.Car;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.storage.CarCacheService;
import ru.otus.bot.telegram.utils.CarMenuStateFactory;


@Component
@RequiredArgsConstructor
public class RegisterNewCar implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final CarMenuStateFactory carMenuStateFactory;
    private final CarCacheService carCacheService;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        carMenuStateFactory.getCarMenuByState(BotState.MODEL)
                           .processUserAnswer(userId, usersAnswer);
        carCacheService.saveCarInCache(userId, new Car().setId(String.valueOf(userId))
                                                        .setChatId(chatId));

        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("car.model"))
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.REGISTER;
    }
}
