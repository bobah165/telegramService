package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
@RequiredArgsConstructor
public class MessageBuilder {
    private final LanguageTranslatorService translator;

    public String getTranslatedMessage(String message) {
        return translator.translateMessage(message);
    }

    public SendMessage createMessageWithKeyboard(long chatId, String message, ReplyKeyboard replyKeyboard) {
        return SendMessage.builder()
                          .text(message)
                          .chatId(String.valueOf(chatId))
                          .replyMarkup(replyKeyboard)
                          .build();
    }
}
