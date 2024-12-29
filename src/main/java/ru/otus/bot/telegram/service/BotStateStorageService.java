package ru.otus.bot.telegram.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.builder.BotStateBuilder;
import ru.otus.bot.telegram.data.BotStateDto;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.integration.http.BotStateRequestService;
import ru.otus.bot.telegram.integration.kafka.publisher.BotStateProducerService;

@Service
@RequiredArgsConstructor
public class BotStateStorageService {
  private final BotStateRequestService requestService;
  private final BotStateProducerService botStateProducerService;
  private final BotStateBuilder builder;

  public void setCurrentBotState(long userId, BotState botState) {
    botStateProducerService.sendBotState(builder.getBotStateWrapper(userId,botState));
  }

  public BotStateDto getUsersCurrentBotState(long userId)  {
    return Optional.ofNullable(requestService.getBotStateFromCarHandler(userId))
      .orElse(builder.getBotStateWrapper(userId,BotState.INFORM));
  }
}
