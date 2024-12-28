package ru.otus.bot.telegram.config.apiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BotStateConfig {
    @Value("${bot.api.subPath.bot-state}")
    private String boStateSubPath;
}
