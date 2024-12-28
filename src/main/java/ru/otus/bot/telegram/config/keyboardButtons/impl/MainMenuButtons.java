package ru.otus.bot.telegram.config.keyboardButtons.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.config.keyboardButtons.KeyboardButtonNames;
import ru.otus.bot.telegram.data.KeyboardButtonName;
import ru.otus.bot.telegram.data.enums.KeyboardMenuButtons;
import ru.otus.bot.telegram.service.MessageBuilder;


@Component
public class MainMenuButtons implements KeyboardButtonNames {
    private final List<String> buttonNames;
    private final MessageBuilder messageBuilder;

    public MainMenuButtons(@Value("${buttons.keyboard.main-menu}") List<String> buttonNames, MessageBuilder messageBuilder) {
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
        return KeyboardMenuButtons.MAIN_MENU;
    }
}
