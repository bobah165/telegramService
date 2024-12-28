package ru.otus.bot.telegram.data;

import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.otus.bot.telegram.data.enums.BotState;

@Data
@Accessors(chain = true)
public class ButtonSateWrapper {
    private BotState botState;
    private Map<String, String> buttonNames;
}
