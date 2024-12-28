package ru.otus.bot.telegram.builder;

import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.BotStateDto;
import ru.otus.bot.telegram.data.enums.BotState;

@Component
public class BotStateBuilder {

    public BotStateDto getBotStateWrapper(Long userId, BotState botState) {
        return new BotStateDto(String.valueOf(userId), botState);
    }
}
