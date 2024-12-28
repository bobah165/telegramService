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
public class CarMaintenanceButtons implements KeyboardButtonNames {
    private final MessageBuilder messageBuilder;
    private final List<String> buttonNames;

    public CarMaintenanceButtons(@Value("${buttons.keyboard.car-maintenance}") List<String> buttonNames, MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
        this.buttonNames = buttonNames;
    }

    public List<KeyboardButtonName> getButtonNames() {
        return buttonNames.stream()
                          .map(messageBuilder::getTranslatedMessage)
                          .map(button->new KeyboardButtonName().setName(button))
                          .collect(Collectors.toList());
    }

    @Override
    public KeyboardMenuButtons getButton() {
        return KeyboardMenuButtons.MAINTENANCE_MENU;
    }
}
