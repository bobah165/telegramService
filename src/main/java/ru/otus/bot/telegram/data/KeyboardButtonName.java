package ru.otus.bot.telegram.data;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.otus.bot.telegram.data.enums.BotState;

@Data
@Accessors(chain = true)
public class KeyboardButtonName {
    private String name;
    private BotState botState;
}
