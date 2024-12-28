package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.api.BotApi;
import ru.otus.bot.telegram.data.enums.BotApiNames;

@Component
@RequiredArgsConstructor
public class BotApiFactory {
    private final List<BotApi> botApis;

    public BotApi getBotApi(BotApiNames botApiName) {
        return botApis.stream()
                      .collect(Collectors.toMap(BotApi::getBotApiName, Function.identity()))
                      .get(botApiName);
    }
}
