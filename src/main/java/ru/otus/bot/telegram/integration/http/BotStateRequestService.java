package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.BotStateDto;

@Service
@RequiredArgsConstructor
public class BotStateRequestService {

    public void sendBotStateToCarHandler(BotStateDto botStateDto) {
    }

    public BotStateDto getBotStateFromCarHandler(Long id) {
       return new BotStateDto();
    }
}
