package ru.otus.bot.telegram.config;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.data.KeyboardButtonName;
import ru.otus.bot.telegram.data.enums.BotState;

@Component
@RequiredArgsConstructor
public class ReplyButtonNamesConfig {
    private final MessageBuilder messageBuilder;

    private final static Map<String, BotState> BUTTON_NAMES = Map.ofEntries(
            Map.entry("button.my.car", BotState.MY_CAR),
            Map.entry("button.settings", BotState.SETTINGS),
            Map.entry("button.my.costs", BotState.MY_COSTS),
            Map.entry("button.my.statistics", BotState.MY_STATISTICS),
            Map.entry("button.register.car", BotState.REGISTER),
            Map.entry("button.car.inform", BotState.CAR_INFORM),
            Map.entry("button.back.to.main.menu", BotState.INFORM),
            Map.entry("button.gas", BotState.ASK_ABOUT_GAS_COSTS),
            Map.entry("button.mileage", BotState.ASK_ABOUT_MILEAGE_COSTS),
            Map.entry("button.spares", BotState.ASK_ABOUT_SPARES_COSTS),
            Map.entry("button.language", BotState.LANGUAGE),
            Map.entry("button.car.maintenance", BotState.MEINTENANCE),
            Map.entry("button.back.to.settings.menu", BotState.BACK_TO_SETTINGS),
            Map.entry("button.total", BotState.TOTAL),
            Map.entry("button.remind", BotState.REMIND),
            Map.entry("button.service.mileage", BotState.SCHEDULE),
            Map.entry("button.maintenance.info", BotState.MAINTENANCE_INFO));


    public List<KeyboardButtonName> getButtonNames() {
        return BUTTON_NAMES.entrySet()
                           .stream()
                           .map(entry -> new KeyboardButtonName().setName(messageBuilder.getTranslatedMessage(entry.getKey()))
                                                                 .setBotState(entry.getValue()))
                           .collect(Collectors.toList());
    }
}
