package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.utils.BotApiFactory;


@Service
@RequiredArgsConstructor
public class CommandService {
    private final BotApiFactory botApiFactory;
    private final MessageBuilder messageBuilder;


    public BotApiMethod<?> handleCommand(Message message) {
        if (message.getText().equals("/start")) {
            return messageBuilder.createMessageWithKeyboard(message.getChatId(),
                    messageBuilder.getTranslatedMessage("car.main.menu"),
                    botApiFactory.getBotApi(BotApiNames.MAIN_MENU_API).getApi());
        }
        return SendMessage.builder()
                          .text("Wrong command. Try again")
                          .chatId(String.valueOf(message.getChatId()))
                          .build();
    }
}

