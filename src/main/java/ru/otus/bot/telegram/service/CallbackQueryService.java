package ru.otus.bot.telegram.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.otus.bot.telegram.config.callBackButtons.CallBackButtonNames;
import ru.otus.bot.telegram.data.ButtonSateWrapper;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.utils.UserAnswerHandlerFactory;

@Service
@RequiredArgsConstructor
public class CallbackQueryService {
    private final BotStateStorageService botStateStorageService;
    private final UserAnswerHandlerFactory userAnswerFactory;
    private final List<CallBackButtonNames> callBackButtonNames;


    public BotApiMethod<?> handleCallbackQuery(CallbackQuery callbackQuery) {
        long userId = callbackQuery.getFrom().getId();
        final BotState botState = getBotState(callbackQuery.getData(), userId);

//        return SendMessage.builder().chatId(String.valueOf(chatId)).text("hello world").build();
        return replayMessage(botState, callbackQuery);
    }

    private BotState getBotState(String calBackData, long userId) {
        return getMapWithBotStateAndCallBackData().entrySet()
                                                  .stream()
                                                  .filter(entry -> entry.getValue().contains(calBackData))
                                                  .map(Map.Entry::getKey)
                                                  .findFirst()
                                                  .orElse(botStateStorageService.getUsersCurrentBotState(userId)
                                                                                .getBotState());
    }

    private Map<BotState, Set<String>> getMapWithBotStateAndCallBackData() {
        return callBackButtonNames.stream()
                                  .map(CallBackButtonNames::getButtonWrapper)
                                  .collect(Collectors.toMap(ButtonSateWrapper::getBotState,
                                        buttonSateWrapper -> buttonSateWrapper.getButtonNames()
                                                                              .keySet()
                          ));
    }

    private BotApiMethod<?> replayMessage(BotState botState, CallbackQuery callbackQuery) {
        final long userId = callbackQuery.getFrom().getId();
        final String chatId = callbackQuery.getMessage().getChatId().toString();
        String data = callbackQuery.getData();

        return userAnswerFactory.getUserAnswerByBotState(botState)
                                .handleUserAnswer(data, userId, chatId);
    }
}
