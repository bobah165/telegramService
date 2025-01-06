package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.apiConfig.BotStateConfig;
import ru.otus.bot.telegram.data.BotStateDto;
import ru.otus.bot.telegram.service.RequestService;

@Service
@RequiredArgsConstructor
public class BotStateRequestService {

  private final RequestService requestService;
  private final BotStateConfig botStateConfig;

    public BotStateDto getBotStateFromCarHandler(Long id) {
      ParameterizedTypeReference<BotStateDto> typeReference = new ParameterizedTypeReference<>() {};
      return requestService.get(botStateConfig.getBaseurlForBotStateService() + botStateConfig.getBoStateSubPath() + "/" + id, typeReference);
    }
}
