package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;


@Component
@RequiredArgsConstructor
public class UserAnswerHandlerFactory {
    private final List<UserAnswerHandler> userAnswerHandlers;

    public UserAnswerHandler getUserAnswerByBotState(BotState botState){
        return userAnswerHandlers.stream()
                                 .collect(Collectors.toMap(UserAnswerHandler::getHandlerName, Function.identity()))
                                 .get(botState);
    }
}
