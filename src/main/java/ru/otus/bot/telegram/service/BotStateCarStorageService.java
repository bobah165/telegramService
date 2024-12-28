package ru.otus.bot.telegram.service;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.BotStateBuilder;
import ru.otus.bot.telegram.data.BotStateDto;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.integration.publisher.BotStateRequestService;

@Service
@AllArgsConstructor
public class BotStateCarStorageService {
    private final BotStateRequestService requestService;
    private final BotStateBuilder builder;

    public void setCurrentBotState(long userId, BotState botState) {
        requestService.sendBotStateToCarHandler(builder.getBotStateWrapper(userId,botState));
    }

    public BotStateDto getUsersCurrentBotState(long userId)  {
        return Optional.ofNullable(requestService.getBotStateFromCarHandler(userId))
                       .orElse(builder.getBotStateWrapper(userId,BotState.INFORM));
    }
}
