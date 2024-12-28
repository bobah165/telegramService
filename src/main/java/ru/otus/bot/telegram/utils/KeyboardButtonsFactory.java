package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.config.keyboardButtons.KeyboardButtonNames;
import ru.otus.bot.telegram.data.enums.KeyboardMenuButtons;

@Component
@RequiredArgsConstructor
public class KeyboardButtonsFactory {
    private final List<KeyboardButtonNames> keyboardButtonNames;

    public KeyboardButtonNames getButtons(KeyboardMenuButtons keyboardMenuButtons) {
        return keyboardButtonNames.stream()
                                     .collect(Collectors.toMap(KeyboardButtonNames::getButton, Function.identity()))
                                     .get(keyboardMenuButtons);
    }
}
