package ru.otus.bot.telegram.builder.settingsMenuBuilder;

import ru.otus.bot.telegram.data.enums.BotState;

public interface SettingMenuBuilder {
    void processUserAnswer(long userId, String userAnswer);
    BotState getBotState();
}
