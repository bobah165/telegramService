package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.otus.bot.telegram.exception.UserAnswerValidationException;


@Service
@RequiredArgsConstructor
public class UpdateService {

    private final MessageService messageService;
    private final CommandService commandService;
    private final CallbackQueryService callbackQueryService;


    public BotApiMethod<?> processUpdate(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().isCommand()) {
                return commandService.handleCommand(update.getMessage());
            }
            if (update.hasMessage() && update.getMessage().hasText()) {
                return messageService.handleMessage(update.getMessage());
            }
            if (update.hasCallbackQuery()) {
                return callbackQueryService.handleCallbackQuery(update.getCallbackQuery());
            }
        } catch (UserAnswerValidationException ex) {
            return SendMessage.builder()
                              .chatId(ex.getChartId())
                              .text(ex.getMessage())
                              .build();
        }
        return null;
    }
}
