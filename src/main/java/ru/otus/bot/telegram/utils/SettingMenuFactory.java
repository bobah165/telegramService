package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.settingsMenuBuilder.SettingMenuBuilder;
import ru.otus.bot.telegram.data.enums.BotState;

@Component
@RequiredArgsConstructor
public class SettingMenuFactory {
    private final List<SettingMenuBuilder> settingMenuBuilders;

    public SettingMenuBuilder getSettingMenuByState(BotState botState) {
        return settingMenuBuilders.stream()
                                   .collect(Collectors.toMap(SettingMenuBuilder::getBotState, Function.identity()))
                                   .get(botState);
    }
}
