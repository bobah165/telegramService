package ru.otus.bot.telegram.data.api;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import ru.otus.bot.telegram.data.enums.BotApiNames;

public interface BotApi {
    ReplyKeyboard getApi();
    BotApiNames getBotApiName();
}
