package ru.otus.bot.telegram.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class TelegramBotConfig {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    @Value("${bot.webHookPath}")
    private String path;
    @Value("${bot.api.baseurlForCarHandler}")
    private String baseurlForCarHandler;
}
