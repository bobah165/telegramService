package ru.otus.bot.telegram.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {
    private final TelegramBotConfig telegramBotConfig;

    @Bean
    public WebClient webClientForCarHandler() {
        return WebClient.builder()
                        .baseUrl(telegramBotConfig.getBaseurlForCarHandler())
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE)
                        .clientConnector(new ReactorClientHttpConnector())
                        .build();
    }
}
