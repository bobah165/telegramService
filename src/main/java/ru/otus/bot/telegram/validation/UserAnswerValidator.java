package ru.otus.bot.telegram.validation;

import ru.otus.bot.telegram.data.enums.BotState;

public interface UserAnswerValidator {
    void validateUserAnswer(String usersAnswer, String chatId);
    BotState getValidatorState();
}
