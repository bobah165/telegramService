package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.utils.UserAnswerHandlerFactory;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final BotStateStorageService botStateStorageService;
    private final UserAnswerHandlerFactory userAnswerFactory;
    private final ReplyButtonNamesService replyButtonNamesService;


    public BotApiMethod<?> handleMessage(Message message) {
        final String inputMessage = message.getText();
        final long userId = message.getFrom().getId();

        BotState botState = getBotState(inputMessage, userId);
        botStateStorageService.setCurrentBotState(userId, botState);

//        return SendMessage.builder().chatId(String.valueOf(message.getChatId())).text("hello world").build();
        return replayMessage(botState, message);
    }

    private BotState getBotState(String inputMessage, long userId) {
        return replyButtonNamesService.getBotStateByMessage(inputMessage, userId);
    }

    private BotApiMethod<?> replayMessage(BotState botState, Message message) {
        final String usersAnswer = message.getText();
        final long userId = message.getFrom().getId();
        final String chatId = message.getChatId().toString();

        return userAnswerFactory.getUserAnswerByBotState(botState)
                                .handleUserAnswer(usersAnswer, userId, chatId);
    }
}
