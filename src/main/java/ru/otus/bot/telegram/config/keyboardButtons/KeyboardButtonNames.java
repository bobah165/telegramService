package ru.otus.bot.telegram.config.keyboardButtons;

import java.util.List;
import ru.otus.bot.telegram.data.KeyboardButtonName;
import ru.otus.bot.telegram.data.enums.KeyboardMenuButtons;

public interface KeyboardButtonNames {
    List<KeyboardButtonName> getButtonNames();
    KeyboardMenuButtons getButton();
}
