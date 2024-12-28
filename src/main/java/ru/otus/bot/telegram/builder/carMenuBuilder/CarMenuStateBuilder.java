package ru.otus.bot.telegram.builder.carMenuBuilder;

import ru.otus.bot.telegram.data.enums.BotState;

public interface CarMenuStateBuilder {
    void processUserAnswer(long userId, String usersAnswer);
    BotState getBotStateName();
}
