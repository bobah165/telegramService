package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.config.callBackButtons.impl.TransmissionCallBackButtonNames;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.service.MessageBuilder;
import ru.otus.bot.telegram.utils.CarMenuStateFactory;


@Component
@RequiredArgsConstructor
public class TransmissionHandler implements UserAnswerHandler {

    private final MessageBuilder messageBuilder;
    private final TransmissionCallBackButtonNames buttonNames;
    private final CarMenuStateFactory carMenuStateFactory;

    @Override
    public BotState getHandlerName() {
        return BotState.TRANSMISSION;
    }

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        String data = getTransmissionType(usersAnswer);
        carMenuStateFactory.getCarMenuByState(BotState.YEAR)
                           .processUserAnswer(userId, data);

        return SendMessage.builder()
                          .chatId(chatId)
                          .text(messageBuilder.getTranslatedMessage("car.year"))
                          .build();
    }

    private String getTransmissionType(String usersAnswer) {
        return buttonNames.getButtonNames()
                          .stream()
                          .filter(callBackButtons -> callBackButtons.getCallBackKey().equals(usersAnswer))
                          .findFirst()
                          .get()
                          .getButtonName();
    }
}
