package ru.otus.bot.telegram.config.keyboardButtons.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.config.keyboardButtons.KeyboardButtonNames;
import ru.otus.bot.telegram.data.KeyboardButtonName;
import ru.otus.bot.telegram.data.enums.KeyboardMenuButtons;


@Component
public class CarMenuButtons implements KeyboardButtonNames {
    private final List<String> buttonNames;
    private final MessageBuilder messageBuilder;

    public CarMenuButtons(@Value("${buttons.keyboard.car-menu}") List<String> buttonNames, MessageBuilder messageBuilder) {
        this.buttonNames = buttonNames;
        this.messageBuilder = messageBuilder;
    }

    public List<KeyboardButtonName> getButtonNames() {
        return buttonNames.stream()
                          .map(messageBuilder::getTranslatedMessage)
                          .map(button->new KeyboardButtonName().setName(button))
                          .collect(Collectors.toList());
    }

    @Override
    public KeyboardMenuButtons getButton() {
        return KeyboardMenuButtons.CAR_MENU;
    }
}
