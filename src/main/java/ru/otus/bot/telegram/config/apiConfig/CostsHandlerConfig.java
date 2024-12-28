package ru.otus.bot.telegram.config.apiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CostsHandlerConfig {
    @Value("${bot.api.subPath.cost-handler}")
    private String costSubPath;
}
