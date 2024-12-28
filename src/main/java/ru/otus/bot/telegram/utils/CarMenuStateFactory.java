package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.carMenuBuilder.CarMenuStateBuilder;
import ru.otus.bot.telegram.data.enums.BotState;

@Component
@RequiredArgsConstructor
public class CarMenuStateFactory {
    private final List<CarMenuStateBuilder> carMenuStateBuilders;

    public CarMenuStateBuilder getCarMenuByState(BotState botState) {
        return carMenuStateBuilders.stream()
                      .collect(Collectors.toMap(CarMenuStateBuilder::getBotStateName, Function.identity()))
                      .get(botState);
    }
}
