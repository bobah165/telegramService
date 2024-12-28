package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.ReplyButtonNamesConfig;
import ru.otus.bot.telegram.data.KeyboardButtonName;
import ru.otus.bot.telegram.data.enums.BotState;


@Service
@RequiredArgsConstructor
public class ReplyButtonNamesService {
    private final ReplyButtonNamesConfig config;
    private final BotStateStorageService botStateStorageService;

    public BotState getBotStateByMessage(String inputMessage, long userId) {
        return config.getButtonNames()
                     .stream()
                     .filter(button -> button.getName().equals(inputMessage))
                     .map(KeyboardButtonName::getBotState)
                     .findFirst()
                     .orElse(botStateStorageService.getUsersCurrentBotState(userId).getBotState());
    }
}
