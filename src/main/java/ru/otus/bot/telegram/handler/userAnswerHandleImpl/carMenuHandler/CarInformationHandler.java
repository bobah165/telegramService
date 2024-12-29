package ru.otus.bot.telegram.handler.userAnswerHandleImpl.carMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.data.Car;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.integration.http.CarHandlerRequestService;


@Component
@RequiredArgsConstructor
public class CarInformationHandler implements UserAnswerHandler {
    private final MessageBuilder builder;
    private final CarHandlerRequestService carHandlerRequestService;

    @Override
    public BotState getHandlerName() {
        return BotState.CAR_INFORM;
    }

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(getCarInfo(carHandlerRequestService.getCarFromCarHandler(userId)))
                          .build();
    }

    private String getCarInfo(Car car) {
        return car.getId().equals("no car") ? getNoCarMessage() : getFormattingCarInform(car);
    }

    private String getFormattingCarInform(Car car) {
        return builder.getTranslatedMessage("result.model") + ": " + car.getModel() + "\n" +
                builder.getTranslatedMessage("result.year") + ": " + car.getYear() + "\n" +
                builder.getTranslatedMessage("result.engine") + ": " + car.getEngineVolume() + "\n" +
                builder.getTranslatedMessage("result.transmission") + ": " + car.getTransmission() + "\n" +
                builder.getTranslatedMessage("result.mileage") + ": " + car.getMileage();
    }

    private String getNoCarMessage() {
        return builder.getTranslatedMessage("car.no.car.message");
    }
}
