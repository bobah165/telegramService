package ru.otus.bot.telegram.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.data.enums.BotState;

public interface UserAnswerHandler {
    SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId);
    BotState getHandlerName();
}
