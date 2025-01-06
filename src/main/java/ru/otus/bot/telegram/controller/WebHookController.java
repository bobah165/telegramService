package ru.otus.bot.telegram.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.otus.bot.telegram.config.apiConfig.BotStateConfig;
import ru.otus.bot.telegram.config.apiConfig.CarHandlerConfig;
import ru.otus.bot.telegram.config.apiConfig.MetricsConfig;
import ru.otus.bot.telegram.data.Metrics;
import ru.otus.bot.telegram.service.RequestService;
import ru.otus.bot.telegram.service.TelegramBotService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WebHookController {
    private final TelegramBotService telegramBot;
    private final RequestService requestService;

    private final CarHandlerConfig carHandlerConfig;
    private final BotStateConfig botStateConfig;
    private final MetricsConfig metricsConfig;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("hello world");
    }

    @GetMapping("/car")
    public ResponseEntity car() {
        log.info("Check car");
        var url = carHandlerConfig.getBaseurlForCarService() + "hello";
        ParameterizedTypeReference<String> typeReference = new ParameterizedTypeReference<>() {};
        var response = requestService.get(url, typeReference);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/botState")
    public ResponseEntity botState() {
        log.info("Check botState");
        var url = botStateConfig.getBaseurlForBotStateService() + "hello";
        ParameterizedTypeReference<String> typeReference = new ParameterizedTypeReference<>() {};
        var response = requestService.get(url, typeReference);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/metric")
    public ResponseEntity metric() {
        log.info("Check metric");
        var url = metricsConfig.getBaseurlForMetricService() + "hello";
        ParameterizedTypeReference<String> typeReference = new ParameterizedTypeReference<>() {};
        var response = requestService.get(url, typeReference);
        return ResponseEntity.ok(response);
    }
}
